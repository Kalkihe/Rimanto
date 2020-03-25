package de.kalkihe.rimanto.view.tablemodel;

import de.kalkihe.rimanto.model.data.IProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Table Model for Projects
 */
public class ProjectTableModel extends GeneralTableModel {
  // List of projects
  List<IProject> projects;

  /**
   *
   * Constructor. Initializes needed variables and initiates reading of data for displaying in table
   * @param projects List of projects to display in the table
   * @throws Exception
   */
  public ProjectTableModel(List<IProject> projects) throws Exception {
    super();
    this.projects = projects;
    this.readColumnNames();
    this.readData();
  }

  /**
   *
   * @param id
   * @return Project to the given id
   */
  public IProject getProjectWithId(int id)
  {
    return this.projects.get(id);
  }

  /**
   * Reads the names of the column in the corresponding objects
   */
  private void readColumnNames()
  {
    // Check if there is at least one project existing
    if (this.projects.size() > 0)
    {
      // Add field for the project id (index position in project list) to columns
      this.columnNames.add("Id");
      // Read the column names from ONE project
      String[] columnNames = this.projects.get(0).getGeneralDataNames();
      // Iterate over all entries in column names
      for (int index = 0; index < columnNames.length; index++)
      {
        // Add column name to list of column names
        this.columnNames.add(this.wordbook.getWordForWithCapitalLeadingLetter(columnNames[index]));
      }
    }
    // if there is no project existing
    else
    {
      // Display a message that there are no projects in the table header
      this.columnNames.add(this.wordbook.getWordForWithCapitalLeadingLetter("no_projects"));
    }
  }

  /**
   * Reads the data from the projects into the corresponding objects
   */
  private void readData()
  {
    // Iterate over every project in list
    for (int index = 0; index < this.projects.size(); index++)
    {
      // Create a new list in list of lists for the current project
      this.tableData.add(index, new ArrayList<String>());
      // Add the id (position in list) of the current project to the data
      this.tableData.get(index).add(Integer.toString(index));
      // Read the rest of the general project data
      String[] currentProjectData = this.projects.get(index).getGeneralProjectData();
      // Iterate over every entry in currentProjectData and put it into data list
      for (int innerIndex = 0; innerIndex < currentProjectData.length; innerIndex++)
      {
        this.tableData.get(index).add(currentProjectData[innerIndex]);
      }
    }
  }

  /**
   * Returns the background color of the passed table in the passed row
   * @param table
   * @param row
   * @return Color of the table in the row
   */
  @Override
  public Color getRowColor(JTable table, int row) {
    int projectId = super.getIdAtRow(table, row);
    IProject project = this.projects.get(projectId);
    if (project.isToReview())
    {
      return Color.RED;
    }
    if (project.hasRisksToReview())
    {
      return Color.YELLOW;
    }
    boolean isSelectedRow = row == table.getSelectedRow();
    if (isSelectedRow)
    {
      return Color.LIGHT_GRAY;
    }
    return Color.WHITE;
  }
}

package de.kalkihe.rimanto.view.panel;

import com.google.inject.Inject;
import de.kalkihe.rimanto.presenter.IEventProcessor;
import de.kalkihe.rimanto.utilities.IWordbook;
import de.kalkihe.rimanto.view.IRimantoView;

import javax.swing.*;

public class PanelGetter implements IPanelGetter{
  private IWordbook wordbook;
  private IEventProcessor eventProcessor;
  private IRimantoView rimantoView;

  @Inject
  public PanelGetter(IWordbook wordbook, IEventProcessor eventProcessor, IRimantoView rimantoView)
  {
    this.wordbook = wordbook;
    this.eventProcessor = eventProcessor;
    this.rimantoView = rimantoView;
  }

  /*
   * Creates new Overview Panel and returns it
   */
  @Override
  public JPanel getPanelForOverview() throws Exception {
    return new OverviewPanel(this.wordbook, this.eventProcessor, this.rimantoView);
  }

  @Override
  public JPanel getPanelForProjectView() throws Exception {
    return new ProjectViewPanel(this.wordbook, this.eventProcessor, this.rimantoView);
  }

  @Override
  public JPanel getPanelForRiskView() throws Exception {
    return new RiskViewPanel(this.wordbook, this.eventProcessor, this.rimantoView);
  }

  @Override
  public JPanel getPanelForProjectInput() {
    return new CreateProjectPanel(this.wordbook, this.eventProcessor, this.rimantoView);
  }

  @Override
  public JPanel getPanelForErrorView() {
    return null;
  }
}

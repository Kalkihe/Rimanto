package de.kalkihe.rimanto.view.panel;

import de.kalkihe.rimanto.model.data.IRisk;
import de.kalkihe.rimanto.presenter.IEventProcessor;
import de.kalkihe.rimanto.utilities.IWordbook;
import de.kalkihe.rimanto.view.IRimantoView;

import javax.swing.*;

public class RiskViewPanel extends GeneralRimantoPanel {
  public RiskViewPanel(IWordbook wordbook, IEventProcessor eventProcessor, IRimantoView rimantoView, IRisk risk) throws Exception {
    super(wordbook, eventProcessor, rimantoView);
    this.buildPanel();
  }

  @Override
  protected void buildPanel() throws Exception {

  }
}

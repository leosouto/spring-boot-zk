package org.dev.app.view;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Div;
import org.zkoss.zul.Textbox;

public class AsyncJsController extends SelectorComposer<Div> {
    private final Logger LOGGER = LoggerFactory.getLogger(AsyncJsController.class);

    @Wire
    Textbox token;

    @Listen("onClick=#callAsyncJs")
    public void callAsyncJs() {
        Clients.evalJavaScript("callAsyncJs('" + token.getUuid() + "')");
    }

    @Listen("onBlur=#token")
    public void onChangeToken() {
        LOGGER.info("Token has changed = {}", token.getValue());
    }
}

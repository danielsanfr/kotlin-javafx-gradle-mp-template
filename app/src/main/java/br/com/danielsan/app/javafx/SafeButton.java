package br.com.danielsan.app.javafx;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import org.jetbrains.annotations.Nullable;

public class SafeButton extends Button {

    @Nullable
    private EventHandler<? super MouseEvent> wrappedMouseClickEventHandler;

    public SafeButton() {
        super();
        initialize();
    }

    public SafeButton(String text) {
        super(text);
        initialize();
    }

    public SafeButton(String text, Node graphic) {
        super(text, graphic);
        initialize();
    }

    private void initialize() {
        setOnMouseClicked(mouseClickEventHandler);
        onMouseClickedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && newValue != mouseClickEventHandler) {
                // TODO: Verify how crash app if this branch is executed
                throw new UnsupportedOperationException("In SafeButton the method that should be called is setSafeOnMouseClicked");
            }
        });
    }

    @Nullable
    public final EventHandler<? super MouseEvent> getSafeOnMouseClicked() {
        return wrappedMouseClickEventHandler;
    }

    public final void setSafeOnMouseClicked(@Nullable EventHandler<? super MouseEvent> value) {
        wrappedMouseClickEventHandler = value;
    }

    private EventHandler<? super MouseEvent> mouseClickEventHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if (wrappedMouseClickEventHandler != null) {
                wrappedMouseClickEventHandler.handle(event);
                setDisable(true);
            }
        }
    };

}

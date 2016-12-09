package com.witype.hfmsample.controller;

import com.witype.hfmsample.app.App;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Stack;

/**
 * Created by Typer_work on 2016/12/9.
 * email:witype716@gmail.com
 * desc:
 */
class Navigation  {

    private Stack<InnerNavigation> stack = new Stack<InnerNavigation>();

    private Controller controller;

    private NavigationViewHolder currentNavigation;

    Navigation(Controller controller) {
        this.controller = controller;
    }

    Parent addNavigation(App app) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/fxml/item_navigation.fxml"));
            NavigationViewHolder holder = new NavigationViewHolder(parent);
            switchTop(holder);
            InnerNavigation innerNavigation = new InnerNavigation(holder,app);
            setCloseListener(innerNavigation,holder.close);
            setChoiceListener(innerNavigation,holder.choice);
            holder.title.setText(app.getName());
            stack.push(innerNavigation);
            return parent;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setCloseListener(final InnerNavigation innerNavigation, HBox hBox) {
        hBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() != MouseButton.PRIMARY) return;
                if (innerNavigation.app.closeAble()) close(innerNavigation);
            }
        });
    }

    private void setChoiceListener(final InnerNavigation innerNavigation, HBox hBox) {
        hBox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() != MouseButton.PRIMARY) return;
                controller.topApp(innerNavigation.app);
                switchTop(innerNavigation.navigation);
            }
        });
    }

    private void close(InnerNavigation innerNavigation) {
        if (!innerNavigation.app.closeAble()) return;
        controller.finishApp(innerNavigation.app);
        controller.finishNavigation(innerNavigation.navigation.parent);
        stack.remove(innerNavigation);
        showTop();
    }

    public void closeByName(String name) {
        for (InnerNavigation innerNavigation : stack) {
            if (innerNavigation.app.getName().equals(name)) {
                close(innerNavigation);
                break;
            }
        }
    }

    private void switchTop(NavigationViewHolder holder) {
        if (currentNavigation != null) {
            currentNavigation.unChoice();
        }
        this.currentNavigation = holder;
        this.currentNavigation.choice();
    }

    private void showTop() {
        if (stack.isEmpty()) return;
        InnerNavigation innerNavigation = stack.peek();
        controller.topApp(innerNavigation.app);
        switchTop(innerNavigation.navigation);
    }

    class InnerNavigation {
        NavigationViewHolder navigation;
        App app;

        InnerNavigation(NavigationViewHolder navigation, App app) {
            this.navigation = navigation;
            this.app = app;
        }
    }

    class NavigationViewHolder {

        Parent parent;
        HBox close;
        HBox choice;
        Label title;

        NavigationViewHolder(Parent parent) {
            this.parent = parent;
            title = (Label) parent.lookup("#navi_title");
            close = (HBox) parent.lookup("#navi_close");
            choice = (HBox) parent.lookup("#navi_choice");
        }

        void choice() {
            title.getStyleClass().clear();
            title.getStyleClass().add("selectable_text_primary");
        }

        void unChoice() {
            title.getStyleClass().clear();
            title.getStyleClass().add("selectable_text_gray");
        }
    }

}

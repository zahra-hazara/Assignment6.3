package controller;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import model.Pet;
import view.PetView;

public class PetController {
    private boolean mouseInside = false;

    public PetController(Pet pet, PetView view) {
        Canvas canvas = view.getCanvas();

        canvas.setOnMouseMoved(e -> {
            mouseInside = true;
            pet.setTarget(e.getX(), e.getY());
        });

        canvas.setOnMouseExited(e -> mouseInside = false);

        // Animation loop
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if(mouseInside) {
                    pet.updatePosition();
                }
                view.draw(pet);
            }
        }.start();
    }
}
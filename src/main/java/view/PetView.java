package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.Pet;

public class PetView {
    private Canvas canvas;
    private final Image petImage;

    public PetView(Canvas canvas, Image petImage) {
        this.canvas = canvas;
        this.petImage = petImage;
    }

    public void draw(Pet pet) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // Center image at pet's coordinates
        gc.drawImage(petImage,
                pet.getX() - petImage.getWidth()/2,
                pet.getY() - petImage.getHeight()/2
        );
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }
}
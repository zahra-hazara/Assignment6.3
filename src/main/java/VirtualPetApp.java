import controller.PetController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Pet;
import view.PetView;
import javafx.scene.image.WritableImage;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.io.InputStream;

public class VirtualPetApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(600, 400);
        Pet pet = new Pet(300, 200, 3);

        // Safe image loading with error handling
        Image petImage = loadPetImage();
        PetView view = new PetView(canvas, petImage);

        new PetController(pet, view);

        StackPane root = new StackPane(canvas);
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.setTitle("Virtual Pet");
        primaryStage.show();
    }

    private Image loadPetImage() {
        try {
            InputStream stream = getClass().getResourceAsStream("/pet.png");
            if(stream == null) {
                throw new IOException("Image not found in resources");
            }
            return new Image(stream);
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
            // Fallback to a simple shape
            return createFallbackImage();
        }
    }

    private Image createFallbackImage() {
        WritableImage image = new WritableImage(40, 40);
        PixelWriter writer = image.getPixelWriter();
        // Create a yellow circle
        for(int y = 0; y < 40; y++) {
            for(int x = 0; x < 40; x++) {
                Color color = (Math.hypot(x-20, y-20) < 18)
                        ? Color.GOLD : Color.TRANSPARENT;
                writer.setColor(x, y, color);
            }
        }
        return image;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
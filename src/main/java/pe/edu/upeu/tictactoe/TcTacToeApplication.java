package pe.edu.upeu.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TcTacToeApplication extends Application {
		ConfigurableApplicationContext configurableApplicationContext;
		Parent parent;
	public static void main(String[] args) {
		System.out.println("Hola estas funcionando");
		launch(args);
		//SpringApplication.run(CalcFxApplication.class, args);
	}

	@Override
	public void init() throws Exception {

		SpringApplicationBuilder builder = new
				SpringApplicationBuilder(TcTacToeApplication.class);
		builder.application().setWebApplicationType(WebApplicationType.NONE);
		configurableApplicationContext =
				builder.run(getParameters().getRaw().toArray(new String[0]));


		//FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/calc.fxml"));
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/tictactoe.fxml"));
		fxmlLoader.setControllerFactory(configurableApplicationContext::getBean);
		parent= fxmlLoader.load();
	}

	@Override
	public void start(Stage stage) throws Exception {
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getBounds();
	//Scene scene = new Scene(parent,bounds.getWidth()/2, bounds.getHeight()/2);
		Scene scene = new Scene(parent);
	// Obtener el tamaño preferido del contenido
		double preferredWidth = parent.prefWidth(-1); // -1 significa que no se restringe el cálculo
		double preferredHeight = parent.prefHeight(-1);
	// Configurar el tamaño mínimo basado en el tamaño preferido
		stage.setMinWidth(preferredWidth);
		stage.setMinHeight(preferredHeight);


		//Application.setUserAgentStylesheet(new PrimerLight().getUserAgentStylesheet());
		//scene.getStylesheets().add(getClass().getResource("/css/bootstrap3.css").toExternalForm());
		scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());
		stage.setScene(scene);
		stage.setTitle("Spring Java-FX");
		stage.show();
	}


}

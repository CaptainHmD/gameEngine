package EngineTseter;

import org.lwjgl.opengl.Display;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameloop {
    public static void main(String[] args) {
        DisplayManager.createDisplay();
        Loader loader = new Loader();
        Renderer renderer = new Renderer();
        float[] vertices = { // E3
                -0.5f, 0.5f, 0f, // v0
                -0.5f, -0.5f, 0f,// v1
                 0.5f, -0.5f, 0f, // v2
                 0.5f, 0.5f, 0f// v3
        };

        int [] induces = {  //E3
                0,1,3, // top left
                3,1,2, // bottom right
        };


        RawModel model = loader.loadToVAO(vertices,induces);

        while(!Display.isCloseRequested()){
           renderer.prepare();
           renderer.render(model);
            DisplayManager.updateDisplay();


        }
        loader.cleanUp();
        DisplayManager.closeDisplay();
        
    }
}

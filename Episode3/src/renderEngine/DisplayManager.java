package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

public class DisplayManager {
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int FPS_CAP = 144;




    public static void createDisplay(){
        ContextAttribs attribs = new ContextAttribs(3,2);
        attribs.withForwardCompatible(true);
        attribs.withProfileCore(true);

        try {
            Display.setDisplayMode(new DisplayMode(WIDTH,HEIGHT)); // Set the width and height for the display
            Display.create(new PixelFormat(),attribs); // create the Display
            Display.setTitle("First Display"); // set title for display
        } catch (LWJGLException e) {
            e.printStackTrace();
        }
        GL11.glViewport(0,0,WIDTH,HEIGHT);
    }
    public static void updateDisplay(){
        Display.sync(FPS_CAP); // set fps for the display
        Display.update();

    }

    public static void closeDisplay(){

    }

}

import Controller.Cesar2Controller;
import Controller.CesarController;
import Controller.VigenereController;
import Model.Caesar;
import Model.Caesar2;
import Model.Vigenere;
import Vue.Caesar2Vue;
import Vue.CaesarVue;
import Vue.VigenereVue;

public class DisplayMVC {
    public DisplayMVC() {


        Caesar model = new Caesar();
        CesarController controller = new CesarController(model);
        CaesarVue vue = new CaesarVue(controller,1000, 1000);
        controller.setVue(vue);


        Caesar2 model2 = new Caesar2();
        Cesar2Controller controller2 = new Cesar2Controller(model2);
        Caesar2Vue vue2 = new Caesar2Vue(controller2,1000, 1000);
        controller2.setVue(vue2);

        Vigenere model3 = new Vigenere();
        VigenereController controller3 = new VigenereController(model3);
        VigenereVue vue3 = new VigenereVue(controller3,1000, 1000);
        controller3.setVue(vue3);


    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DisplayMVC();
            }
        });
    }
}

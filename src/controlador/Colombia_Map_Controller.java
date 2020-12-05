package controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import model.Program;

public class Colombia_Map_Controller implements Initializable{

    @FXML
    private Line Medellin_Manizales,Manizales_Tunja,Yopal_Arauca,Tunja_Yopal;

    @FXML
    private Line Manizales_Bucaramanga,Cali_Manizales,Manizales_Bogota,Cali_Bogota;

    @FXML
    private Line Barranquilla_Rioacha,Cartagena_Barranquilla,Monteria_Cartagena;

    @FXML
    private Line Monteria_Medellin, Quibdo_Medellin,Quibdo_Cali,Popayan_Cali,Pasto_Popayan,Tunja_Bucaramanga;

    @FXML
    private Line Villavicencio_Yopal,Bogota_Villavicencio,Villavicencio_Mitu;

    @FXML
    private Line Popayan_Mocoa,Pasto_Mocoa,Mocoa_Leticia,Mocoa_Mitu,Mitu_Leticia;

    @FXML
    private Line Monteria_Bucaramanga,Bucaramanga_Arauca,Medellin_Bucaramanga,Bogota_Tunja;

    @FXML
    private CheckBox Quibdo,Leticia,Cali,Popayan,Pasto,Mocoa,Rioacha,Barranquilla,Cartagena,Arauca,Bucaramanga,Tunja,Manizales,Bogota,Yopal,Villavicencio,Mitu,Monteria,Medellin;

    @FXML
    private Text txtDistancia,txtCiudades,txtTiempo,txtOrigenDestino,textCiudades;
    

    
    private String origen;
    private String destino;
    private Program programita;
    
    
    @FXML
    void calcularRuta(ActionEvent event) {
    	origen="";
    	destino="";

    	if(!tomarOrigenDestino()) {
			Alert alert= new Alert(AlertType.INFORMATION);
			alert.setHeaderText(null);
			alert.setContentText("Por favor elige solamente 2 ciudades.");
			alert.setTitle("Lo sentimos");
			alert.showAndWait();
			ponerVisibleCiudades();
	    	ponerInvisibleCaminos();

    	}else {
    		txtOrigenDestino.setText(origen+" - "+destino);
    		int distancia=programita.getG().distanciaEntreCiudades(origen, destino);
    		txtDistancia.setText("Distancia: "+distancia+" Kilometros");
    		txtTiempo.setText("Tiempo: "+String.format("%.2f", ((double)distancia/70))+" Horas");
    		ArrayList<String> citys=programita.getG().caminoMasCorto(origen, destino).getCitys();
    		txtCiudades.setText("Ciudades: "+citys.size());
    		String rutaCiudades="\n\t CIUDADES\n\n";
    		for(int i=0;i<citys.size();i++) {
    			rutaCiudades+="\t - "+citys.get(i)+"\n";
    		}
    		textCiudades.setText(rutaCiudades);
    		ponerVisibleCaminos(programita.getG().caminoMasCorto(origen, destino).getRoads());
    	}
    	
    }

    @FXML
    void reiniciarGPS(ActionEvent event) {
    	origen="";
    	destino="";
    	textCiudades.setText("");
    	txtCiudades.setText("Ciudades: 0");
    	txtDistancia.setText("Distancia: 0 Kilometros");
    	txtTiempo.setText("Tiempo: 0 Horas");
    	txtOrigenDestino.setText("  -  ");
    	ponerInvisibleCaminos();
    	ponerVisibleCiudades();
    	
    }
    
    
    

    public void ponerVisibleCaminos(ArrayList<String> arrayList) {
    	
    	for(int i=0;i<arrayList.size();i++) {
    		String opcion1=arrayList.get(i);
    		String opcion2="";
    		String[] voltear=opcion1.split("_");
    		opcion2=voltear[1]+"_"+voltear[0];
    		
    		if(opcion1.equals("Medellin_Manizales")||opcion1.equals("Manizales_Medellin")||opcion2.equals("Medellin_Manizales")||opcion2.equals("Manizales_Medellin")) {
    			Medellin_Manizales.setVisible(true);
    		}
    		if(opcion1.equals("Manizales_Tunja")||opcion1.equals("Tunja_Manizales")||opcion2.equals("Manizales_Tunja")||opcion2.equals("Tunja_Manizales")) {
    			Manizales_Tunja.setVisible(true);
    		}
    		if(opcion1.equals("Yopal_Arauca")||opcion1.equals("Arauca_Yopal")||opcion2.equals("Yopal_Arauca")||opcion2.equals("Arauca_Yopal")) {
    			Yopal_Arauca.setVisible(true);
    		}
    		if(opcion1.equals("Tunja_Yopal")||opcion1.equals("Yopal_Tunja")||opcion2.equals("Tunja_Yopal")||opcion2.equals("Yopal_Tunja")) {
    			Tunja_Yopal.setVisible(true);
    		}
    		if(opcion1.equals("Manizales_Bucaramanga")||opcion1.equals("Bucaramanga_Manizales")||opcion2.equals("Manizales_Bucaramanga")||opcion2.equals("Bucaramanga_Manizales")) {
    			Manizales_Bucaramanga.setVisible(true);
    		}
    		if(opcion1.equals("Cali_Manizales")||opcion1.equals("Manizales_Cali")||opcion2.equals("Cali_Manizales")||opcion2.equals("Manizales_Cali")) {
    			Cali_Manizales.setVisible(true);
    		}
    		if(opcion1.equals("Manizales_Bogota")||opcion1.equals("Bogota_Manizales")||opcion2.equals("Manizales_Bogota")||opcion2.equals("Bogota_Manizales")) {
    			Manizales_Bogota.setVisible(true);
    		}
    		if(opcion1.equals("Cali_Bogota")||opcion1.equals("Bogota_Cali")||opcion2.equals("Cali_Bogota")||opcion2.equals("Bogota_Cali")) {
    			Cali_Bogota.setVisible(true);
    		}
    		if(opcion1.equals("Barranquilla_Rioacha")||opcion1.equals("Rioacha_Barranquilla")||opcion2.equals("Barranquilla_Rioacha")||opcion2.equals("Rioacha_Barranquilla")) {
    			Barranquilla_Rioacha.setVisible(true);
    		}
    		if(opcion1.equals("Cartagena_Barranquilla")||opcion1.equals("Barranquilla_Cartagena")||opcion2.equals("Cartagena_Barranquilla")||opcion2.equals("Barranquilla_Cartagena")) {
    			Cartagena_Barranquilla.setVisible(true);
    		}
    		if(opcion1.equals("Monteria_Cartagena")||opcion1.equals("Cartagena_Monteria")||opcion2.equals("Monteria_Cartagena")||opcion2.equals("Cartagena_Monteria")) {
    			Monteria_Cartagena.setVisible(true);
    		}
    		if(opcion1.equals("Monteria_Medellin")||opcion1.equals("Medellin_Monteria")||opcion2.equals("Monteria_Medellin")||opcion2.equals("Medellin_Monteria")) {
    			Monteria_Medellin.setVisible(true);
    		}
    		if(opcion1.equals("Quibdo_Medellin")||opcion1.equals("Medellin_Quibdo")||opcion2.equals("Quibdo_Medellin")||opcion2.equals("Medellin_Quibdo")) {
    			Quibdo_Medellin.setVisible(true);
    		} 		
    		if(opcion1.equals("Quibdo_Cali")||opcion1.equals("Cali_Quibdo")||opcion2.equals("Quibdo_Cali")||opcion2.equals("Cali_Quibdo")) {
    			Quibdo_Cali.setVisible(true);
    		} 		
    		if(opcion1.equals("Popayan_Cali")||opcion1.equals("Cali_Popayan")||opcion2.equals("Popayan_Cali")||opcion2.equals("Cali_Popayan")) {
    			Popayan_Cali.setVisible(true);
    		} 		
    		if(opcion1.equals("Tunja_Bucaramanga")||opcion1.equals("Bucaramanga_Tunja")||opcion2.equals("Tunja_Bucaramanga")||opcion2.equals("Bucaramanga_Tunja")) {
    			Tunja_Bucaramanga.setVisible(true);
    		} 		
    		if(opcion1.equals("Villavicencio_Yopal")||opcion1.equals("Yopal_Villavicencio")||opcion2.equals("Villavicencio_Yopal")||opcion2.equals("Yopal_Villavicencio")) {
    			Villavicencio_Yopal.setVisible(true);
    		} 		
    		if(opcion1.equals("Bogota_Villavicencio")||opcion1.equals("Villavicencio_Bogota")||opcion2.equals("Bogota_Villavicencio")||opcion2.equals("Villavicencio_Bogota")) {
    			Bogota_Villavicencio.setVisible(true);
    		} 
    		if(opcion1.equals("Villavicencio_Mitu")||opcion1.equals("Mitu_Villavicencio")||opcion2.equals("Villavicencio_Mitu")||opcion2.equals("Mitu_Villavicencio")) {
    			Villavicencio_Mitu.setVisible(true);
    		} 
    		if(opcion1.equals("Popayan_Mocoa")||opcion1.equals("Mocoa_Popayan")||opcion2.equals("Popayan_Mocoa")||opcion2.equals("Mocoa_Popayan")) {
    			Popayan_Mocoa.setVisible(true);
    		} 
    		if(opcion1.equals("Pasto_Mocoa")||opcion1.equals("Mocoa_Pasto")||opcion2.equals("Pasto_Mocoa")||opcion2.equals("Mocoa_Pasto")) {
    			Pasto_Mocoa.setVisible(true);
    		} 
    		if(opcion1.equals("Mocoa_Leticia")||opcion1.equals("Leticia_Mocoa")||opcion2.equals("Mocoa_Leticia")||opcion2.equals("Leticia_Mocoa")) {
    			Mocoa_Leticia.setVisible(true);
    		} 
    		if(opcion1.equals("Mocoa_Mitu")||opcion1.equals("Mitu_Mocoa")||opcion2.equals("Mocoa_Mitu")||opcion2.equals("Mitu_Mocoa")) {
    			Mocoa_Mitu.setVisible(true);
    		} 
    		if(opcion1.equals("Mitu_Leticia")||opcion1.equals("Leticia_Mitu")||opcion2.equals("Mitu_Leticia")||opcion2.equals("Leticia_Mitu")) {
    			Mitu_Leticia.setVisible(true);
    		} 
    		if(opcion1.equals("Monteria_Bucaramanga")||opcion1.equals("Bucaramanga_Monteria")||opcion2.equals("Monteria_Bucaramanga")||opcion2.equals("Bucaramanga_Monteria")) {
    			Monteria_Bucaramanga.setVisible(true);
    		} 
    		if(opcion1.equals("Bucaramanga_Arauca")||opcion1.equals("Arauca_Bucaramanga")||opcion2.equals("Bucaramanga_Arauca")||opcion2.equals("Arauca_Bucaramanga")) {
    			Bucaramanga_Arauca.setVisible(true);
    		} 
    		if(opcion1.equals("Medellin_Bucaramanga")||opcion1.equals("Bucaramanga_Medellin")||opcion2.equals("Medellin_Bucaramanga")||opcion2.equals("Bucaramanga_Medellin")) {
    			Medellin_Bucaramanga.setVisible(true);
    		} 
    		if(opcion1.equals("Bogota_Tunja")||opcion1.equals("Tunja_Bogota")||opcion2.equals("Bogota_Tunja")||opcion2.equals("Tunja_Bogota")) {
    			Bogota_Tunja.setVisible(true);
    		} 
    		if(opcion1.equals("Popayan_Cali")||opcion1.equals("Cali_Popayan")||opcion2.equals("Popayan_Cali")||opcion2.equals("Cali_Popayan")) {
    			Popayan_Cali.setVisible(true);
    		} 
    	}
    }
    
    
    
	public void ponerInvisibleCaminos() {
    	
    	Medellin_Manizales.setVisible(false);
        Manizales_Tunja.setVisible(false);
        Yopal_Arauca.setVisible(false);
        Tunja_Yopal.setVisible(false);
        Manizales_Bucaramanga.setVisible(false);
        Cali_Manizales.setVisible(false);
        Manizales_Bogota.setVisible(false);
        Cali_Bogota.setVisible(false);
        Barranquilla_Rioacha.setVisible(false);
        Cartagena_Barranquilla.setVisible(false);
        Monteria_Cartagena.setVisible(false);
        Monteria_Medellin.setVisible(false);
        Quibdo_Medellin.setVisible(false);
        Quibdo_Cali.setVisible(false);
        Popayan_Cali.setVisible(false);
        Pasto_Popayan.setVisible(false);
        Tunja_Bucaramanga.setVisible(false);
        Villavicencio_Yopal.setVisible(false);
        Bogota_Villavicencio.setVisible(false);
        Villavicencio_Mitu.setVisible(false);
        Popayan_Mocoa.setVisible(false);
        Pasto_Mocoa.setVisible(false);
        Mocoa_Leticia.setVisible(false);
        Mocoa_Mitu.setVisible(false);
        Mitu_Leticia.setVisible(false);
        Monteria_Bucaramanga.setVisible(false);
        Bucaramanga_Arauca.setVisible(false);
        Medellin_Bucaramanga.setVisible(false);
        Bogota_Tunja.setVisible(false);

    }
	
	

	
    


    
    private void ponerVisibleCiudades() {
    	
        Quibdo.setVisible(true);
        Leticia.setVisible(true);
        Cali.setVisible(true);
        Popayan.setVisible(true);
        Pasto.setVisible(true);
        Mocoa.setVisible(true);
        Rioacha.setVisible(true);
        Barranquilla.setVisible(true);
        Cartagena.setVisible(true);
        Arauca.setVisible(true);
        Bucaramanga.setVisible(true);
        Tunja.setVisible(true);
        Manizales.setVisible(true);
        Bogota.setVisible(true);
        Yopal.setVisible(true);
        Villavicencio.setVisible(true);
        Mitu.setVisible(true);
        Monteria.setVisible(true);
        Medellin.setVisible(true);

		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ponerInvisibleCaminos();
		programita = new Program();
	}
	
    
	public boolean tomarOrigenDestino() {
	   	int seleccionados=0;
	    	
	        if(Quibdo.isSelected()) {
	        	if(origen.equals("")) {        		origen="Quibdo";
	        	}else {        		destino="Quibdo";
	        	}
	        	seleccionados++;
	        }else {
	        	Quibdo.setVisible(false);
	        }
	        if(Leticia.isSelected()) {
	        	if(origen.equals("")) {        		origen="Leticia";
	        	}else {        		destino="Leticia";
	        	}
	        	seleccionados++;
	        }else {
	        	Leticia.setVisible(false);
	        }
	        if(Cali.isSelected()) {
	        	if(origen.equals("")) {        		origen="Cali";
	        	}else {        		destino="Cali";
	        	}
	        	seleccionados++;
	        }else {
	        	Cali.setVisible(false);
	        }
	        if(Popayan.isSelected()) {
	        	if(origen.equals("")) {        		origen="Popayan";
	        	}else {        		destino="Popayan";
	        	}
	        	seleccionados++;
	        }else {
	        	Popayan.setVisible(false);
	        }       
	        if(Pasto.isSelected()) {
	        	if(origen.equals("")) {        		origen="Pasto";
	        	}else {        		destino="Pasto";
	        	}
	        	seleccionados++;
	        }else {
	        	Pasto.setVisible(false);
	        }
	        if(Mocoa.isSelected()) {
	        	if(origen.equals("")) {        		origen="Mocoa";
	        	}else {        		destino="Mocoa";
	        	}
	        	seleccionados++;
	        }else {
	        	Mocoa.setVisible(false);
	        }
	        if(Rioacha.isSelected()) {
	        	if(origen.equals("")) {        		origen="Rioacha";
	        	}else {        		destino="Rioacha";
	        	}
	        	seleccionados++;
	        }else {
	        	Rioacha.setVisible(false);
	        }
	        if(Barranquilla.isSelected()) {
	        	if(origen.equals("")) {        		origen="Barranquilla";
	        	}else {        		destino="Barranquilla";
	        	}
	        	seleccionados++;
	        }else {
	        	Barranquilla.setVisible(false);
	        }
	        if(Cartagena.isSelected()) {
	        	if(origen.equals("")) {        		origen="Cartagena";
	        	}else {        		destino="Cartagena";
	        	}
	        	seleccionados++;
	        }else {
	        	Cartagena.setVisible(false);
	        }
	        if(Arauca.isSelected()) {
	        	if(origen.equals("")) {        		origen="Arauca";
	        	}else {        		destino="Arauca";
	        	}
	        	seleccionados++;
	        }else {
	        	Arauca.setVisible(false);
	        }
	        if(Bucaramanga.isSelected()) {
	        	if(origen.equals("")) {        		origen="Bucaramanga";
	        	}else {        		destino="Bucaramanga";
	        	}
	        	seleccionados++;
	        }else {
	        	Bucaramanga.setVisible(false);
	        }
	        if(Tunja.isSelected()) {
	        	if(origen.equals("")) {        		origen="Tunja";
	        	}else {        		destino="Tunja";
	        	}
	        	seleccionados++;
	        }else {
	        	Tunja.setVisible(false);
	        }
	        if(Manizales.isSelected()) {
	        	if(origen.equals("")) {        		origen="Manizales";
	        	}else {        		destino="Manizales";
	        	}
	        	seleccionados++;
	        }else {
	        	Manizales.setVisible(false);
	        }
	        if(Bogota.isSelected()) {
	        	if(origen.equals("")) {        		origen="Bogota";
	        	}else {        		destino="Bogota";
	        	}
	        	seleccionados++;
	        }else {
	        	Bogota.setVisible(false);
	        }
	        if(Yopal.isSelected()) {
	        	if(origen.equals("")) {        		origen="Yopal";
	        	}else {        		destino="Yopal";
	        	}
	        	seleccionados++;
	        }else {
	        	Yopal.setVisible(false);
	        }
	        if(Villavicencio.isSelected()) {
	        	if(origen.equals("")) {        		origen="Villavicencio";
	        	}else {        		destino="Villavicencio";
	        	}
	        	seleccionados++;
	        }else {
	        	Villavicencio.setVisible(false);
	        }
	        if(Mitu.isSelected()) {
	        	if(origen.equals("")) {        		origen="Mitu";
	        	}else {        		destino="Mitu";
	        	}
	        	seleccionados++;
	        }else {
	        	Mitu.setVisible(false);
	        }
	        if(Monteria.isSelected()) {
	        	if(origen.equals("")) {        		origen="Monteria";
	        	}else {        		destino="Monteria";
	        	}
	        	seleccionados++;
	        }else {
	        	Monteria.setVisible(false);
	        }
	        if(Medellin.isSelected()) {
	        	if(origen.equals("")) {        		origen="Medellin";
	        	}else {        		destino="Medellin";
	        	}
	        	seleccionados++;
	        }else {
	        	Medellin.setVisible(false);
	        }

	       
	        if(seleccionados==2) {
	        	return true;
	        }else {
	        	return false;
	        }
		}
	
	
}

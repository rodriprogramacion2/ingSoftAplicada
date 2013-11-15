package ar.edu.um.isa.mb.ws;

import ar.edu.um.isa.common.ServiceLocator;

public class MicrobloggingApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ServiceLocator.getInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

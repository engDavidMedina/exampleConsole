package com.ar.console.project.messages;

public enum MessagesEnum {

	UNRECOGNIZED_COMMAND_ERROR {
		@Override
		public String toString() {
			return "Opción no encontrada";
		}
	},	
	UNRECOGNIZED_FORMAT_ERROR {
		@Override
		public String toString() {
			return "El formato no es el correcto";
		}
	},	
	DIVIDE_BY_ZERO_ERROR {
		@Override
		public String toString() {
			return "Error al dividir entre 0";
		}
	},	
	SYSTEM_ERROR {
		@Override
		public String toString() {
			return "Ocurrió un error inesperado";
		}
	};
}

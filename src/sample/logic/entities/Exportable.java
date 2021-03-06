package sample.logic.entities;

import java.util.List;

public abstract class Exportable {

    public static final Character CSV = ',';
    public static final Character PCS = ';';
    public static final Character BSV = '|';

    public abstract List<String> toListString();

    public abstract String getHeader();

    public static String getExtension(Character separateValue) throws Exception {
        String result;
        //separate Value - El encargado de asignar los separadores, que dicen a la maquina como leer el archivo
        switch (separateValue){
            case ',':
                result = "csv";
                break;
            case ';':
                result = "pcs";
                break;
            case '|':
                result = "bsv";
                break;
            default:
                throw new Exception("Character not supported");
        }
        return result;
    }

    public String toExportValue(Character separateValue){
        List<String> listString = this.toListString();
        StringBuilder sb = new StringBuilder();

        for(String s : listString)
            sb.append(s).append(separateValue);

        return sb.toString();
    }

}

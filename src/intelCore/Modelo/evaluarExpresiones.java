package intelCore.Modelo;

import java.util.regex.*;
public class evaluarExpresiones {

   public boolean validarDatosDeEntrada(String cadena){
        Pattern pat = Pattern.compile("(^(i3)-(10|9|8|7|6|4)(320|325|305|105|100|300|350|101|170|370|160|360|150|130|330|340|305T|105T|105F|100F|300T|100T|350K|350KF|101E|101TE|098P|170T|370T|160T|360T|150T|350T|130T|330T)$)|(^(i5)-(11|10|9|8|7|6|5|4)(600T|600KF|600K|600|500T|500F|500|400T|400F|400|685R|585R|402P|675R|675C|575R|460S|460T|460|590|590S|590T|690|690K|690S|690T|440|440S|430|430S|570|570R|570S|570T|670|670K|670R|670S|670T)$)|(^(i7)-(11|10|9|8|7|6|5|4)(700|700T|700K|700KF|700F|086K|785R|775R|775C|785T|790|790K|790S|790T|771|765T|770|770K|770R|770S|770T)$)|(^(i9)-(11|10|9)(900|900T|900KF|900K|900F|900KS|850K|850)$)|(^(i9|i7|i5)-(10|9|7|6|5|4)(980XE|940X|920X|900X|960X|820X|800X|740X|640X|950X|900K|850K|800K|930K|820K)$)");
        Matcher mat = pat.matcher(cadena);

        return mat.matches();
    }
}

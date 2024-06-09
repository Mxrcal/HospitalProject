
import java.util.Scanner;

//@author Marcal
public class P3_IllescasB {

    public static void main(String[] args) {
        //Declarem connstants
        final int TIS_MIN = 100000;
        final int TIS_MAX = 999999;
        final int SIMP_MIN = 0;
        final int SIMP_MAX = 3;
        final int EXP_MIN = 0;
        final int EXP_MAX = 3;
        final int NIV_MIN = 0;
        final int NIV_MAX = 5;
        final int TEMP_MIN = 27;
        final int TEMP_MAX = 45;
        final int INTENTS_MAX = 3;

        //Simptomes
        final int DOLOR = 0;
        final int LESIO_TRAUMA = 1;
        final int FEBRA_ALTA = 2;
        final int CONFUSIO_DESO = 3;
        final String DOLOR_NOM = "Dolor";
        final String LESIO_TRAUMA_NOM = "Lesió traumàtica";
        final String FEBRA_ALTA_NOM = "Febra alta";
        final String CONFUSIO_DES_NOM = "Confusió o desorientació";

        //Exploracions
        final int DOLOR_TORA = 0;
        final int DOLOR_ABDO = 1;
        final int DOLOR_CAP = 2;
        final int MIGRANYA = 3;
        final String DOLOR_TORA_NOM = "Dolor toràcic";
        final String DOLOR_ABDO_NOM = "Dolor abdominal";
        final String DOLOR_CAP_NOM = "Dolor de cap";
        final String MIGRANYA_NOM = "Migranya";

        final int FRAC_OS = 0;
        final int FER_BALA = 1;
        final int CREMADA = 2;
        final int LES_CEREB = 3;
        final String FRAC_OS_NOM = "Fractura òssia";
        final String FER_BALA_NOM = "Ferida de bala";
        final String CREMADA_NOM = "Cremada";
        final String LES_CEREB_NOM = "Lesió cerebral traumàtica";

        final int PNEU = 0;
        final int MENIN = 1;
        final int INFE_VIRAL = 2;
        final int REA_ALER = 3;
        final String PNEU_NOM = "Pneumònia";
        final String MENIN_NOM = "Meningitis";
        final String INFE_VIRAL_NOM = "Infecció viral";
        final String REA_ALER_NOM = "Reacció al·lèrgica";

        final int INTOX = 0;
        final int DES_SEV = 1;
        final int ACC_CEREB = 2;
        final int CONF_DES = 3;
        final String INTOX_NOM = "Intoxicació per drogues o alcohol";
        final String DES_SEV_NOM = "Deshidratació severa";
        final String ACC_CEREB_NOM = "Accident cerebrovascular";
        final String CONF_DES_NOM = "Confusió o desorientació";

        //Definim variables
        int tis = 0, simptoma = 0, exploracio = 0, intents = 0;
        int nivellPrioritat = 0, temperaturaActual = 0;
        int seguir;
        String tipusExploracio = "";
        String tipusDolor = "";
        boolean dadaCorrecta;
        boolean usuariNou;
        Scanner lector = new Scanner(System.in);

        // Arrays para almacenar los datos de los pacientes
        int[] tisArray = new int[100];
        int[] simptomaArray = new int[100];
        int[] exploracioArray = new int[100];
        int[] nivellPrioritatArray = new int[100];
        int[] temperaturaActualArray = new int[100];
        String[] tipusDolorArray = new String[100];
        String[] tipusExploracioArray = new String[100];
        int numPacients = 0;

        do {//Primer bucle per demanar si vol introduir nou usuari
            intents = 0;
            do { //Bucle per 3 intents
                //Iniciem el do per verificar els intents
                //Demanem el TIS i el verifiquem
                System.out.println("Introduiu el vostre TIS: ");
                dadaCorrecta = lector.hasNextInt(); //Pregunta si la dada es un enter
                if (dadaCorrecta) {
                    tis = lector.nextInt(); //Llegeig l'enter
                    if ((tis < TIS_MIN) || (tis > TIS_MAX)) { //Verifica que està dins del rang indicat
                        System.out.println("Error, TIS invàlid.");
                        dadaCorrecta = false; //Com que no està dins del rang, no es correcta la dada.
                    }
                } else {
                    lector.next(); //Netega el buffer després d'introduir una dada que no es un enter
                    System.out.println("Dada introduida incorrecta");
                }
                intents++; //Comptador pels intenats
            } while (!dadaCorrecta && intents < INTENTS_MAX);//Verifiquem els intents
            if (!dadaCorrecta) { //Finalitza si es superen els intents
                System.out.println("Intents esgotats, finalitzant programa");
                return;
            }
            if (dadaCorrecta) { //Fins aqui si tot es correcta continua.
                intents = 0; //Reset dels intents abans del seguent bucle.
                do { //Bucle pels intents.
                    System.out.println("Quin símptoma presentes?");
                    System.out.println("Dolor (0)");
                    System.out.println("Lesió traumàtica (1)");
                    System.out.println("Febra alta (2)");
                    System.out.println("Confusió o desorientació (3)");
                    System.out.println("Seleccioni simptoma:");
                    dadaCorrecta = lector.hasNextInt(); //Pregunta si la dada es un enter
                    if (dadaCorrecta) { //Entra en cas de ser-ho.
                        simptoma = lector.nextInt(); //Llegeix la dada
                        if ((simptoma < SIMP_MIN) || (simptoma > SIMP_MAX)) { //Dona error si no es un numero de 0-3
                            System.out.println("Error, Símptoma invàlid");
                            dadaCorrecta = false; //Com que no es un num de 0-3, la dada es incorrecta.
                        } else { //Si tot es correcta continua.
                            intents = 0; //Reset dels intents.
                            switch (simptoma) {
                                //Demanem el tipus de simptoma, i el guardem el tipus seleccionat
                                case DOLOR:
                                    System.out.println("Selecciona el tipus de dolor:");
                                    System.out.println("Dolor toràcic (0)");
                                    System.out.println("Dolor abdominal (1)");
                                    System.out.println("Dolor de cap (2)");
                                    System.out.println("Migranya (3)");
                                    tipusDolor = DOLOR_NOM; //Guardem el tipus seleccionat.
                                    break;
                                case LESIO_TRAUMA:
                                    System.out.println("Selecciona el tipus de lesió:");
                                    System.out.println("Fractura òssia (0)");
                                    System.out.println("Ferida de bala (1)");
                                    System.out.println("Cremada (2)");
                                    System.out.println("Lesió cerebral traumàtica (3)");
                                    tipusDolor = LESIO_TRAUMA_NOM;
                                    break;
                                case FEBRA_ALTA:
                                    System.out.println("Selecciona el tipus de febre alta:");
                                    System.out.println("Pneumònia (0)");
                                    System.out.println("Meningitis (1)");
                                    System.out.println("Infecció viral (2)");
                                    System.out.println("Reacció al·lèrgica (3)");
                                    tipusDolor = FEBRA_ALTA_NOM;
                                    break;
                                case CONFUSIO_DESO:
                                    System.out.println("Selecciona el tipus de confusió o desorientació:");
                                    System.out.println("Intoxicació per drogues o alcohol (0)");
                                    System.out.println("Deshidratació severa (1)");
                                    System.out.println("Accident cerebrovascular (2)");
                                    System.out.println("Hipoglucèmia severa (3)");
                                    tipusDolor = CONFUSIO_DES_NOM;
                                    break;
                            }
                            do { //Bucle per comprobar els intents.
                                //Verifiquem que la dada introduida sigui correcta
                                System.out.println("Seleccioni exploració:");
                                dadaCorrecta = lector.hasNextInt();

                                if (dadaCorrecta) {
                                    exploracio = lector.nextInt(); //Si es correcta la llegeix
                                    if ((exploracio < EXP_MIN) || (exploracio > EXP_MAX)) { //Entra si no està dins del establert.
                                        System.out.println("Error, exploració invàlida");
                                        dadaCorrecta = false; //Dada incorrecta, error.
                                    }
                                }
                                if (dadaCorrecta) { //Continua si la dada es correcta.
                                    //Obtenim el tipus d'exploració i la guardem
                                    switch (simptoma) {
                                        case DOLOR://Per a simptoma dolor: guarda el tipus de exp.
                                            switch (exploracio) {
                                                case DOLOR_TORA:
                                                    tipusExploracio = DOLOR_TORA_NOM;
                                                    break;
                                                case DOLOR_ABDO:
                                                    tipusExploracio = DOLOR_ABDO_NOM;
                                                    break;
                                                case DOLOR_CAP:
                                                    tipusExploracio = DOLOR_CAP_NOM;
                                                    break;
                                                case MIGRANYA:
                                                    tipusExploracio = MIGRANYA_NOM;
                                                    break;
                                            }
                                            break;
                                        case LESIO_TRAUMA: //Simptoma lesio, etc.
                                            switch (exploracio) {
                                                case FRAC_OS:
                                                    tipusExploracio = FRAC_OS_NOM;
                                                    break;
                                                case FER_BALA:
                                                    tipusExploracio = FER_BALA_NOM;
                                                    break;
                                                case CREMADA:
                                                    tipusExploracio = CREMADA_NOM;
                                                    break;
                                                case LES_CEREB:
                                                    tipusExploracio = LES_CEREB_NOM;
                                                    break;
                                            }
                                            break;
                                        case FEBRA_ALTA:
                                            switch (exploracio) {
                                                case PNEU:
                                                    tipusExploracio = PNEU_NOM;
                                                    break;
                                                case MENIN:
                                                    tipusExploracio = MENIN_NOM;
                                                    break;
                                                case INFE_VIRAL:
                                                    tipusExploracio = INFE_VIRAL_NOM;
                                                    break;
                                                case REA_ALER:
                                                    tipusExploracio = REA_ALER_NOM;
                                                    break;
                                            }
                                            break;
                                        case CONFUSIO_DESO:
                                            switch (exploracio) {
                                                case INTOX:
                                                    tipusExploracio = INTOX_NOM;
                                                    break;
                                                case DES_SEV:
                                                    tipusExploracio = DES_SEV_NOM;
                                                    break;
                                                case ACC_CEREB:
                                                    tipusExploracio = ACC_CEREB_NOM;
                                                    break;
                                                case CONF_DES:
                                                    tipusExploracio = CONF_DES_NOM;
                                                    break;
                                            }
                                            break;
                                    }
                                }
                                intents++; //Augmentem el contador una vegada arribi aqui
                            } while (!dadaCorrecta && intents < INTENTS_MAX);//Comproba que la dada sigui correcta, i no hagi esgotat intents.
                            if (!dadaCorrecta) { //Si ha superat els intents, finalitza.
                                System.out.println("Has superat els intents, finalitzant programa...");
                            }
                        }
                    } else {
                        System.out.println("Dada incorrecta.");
                        lector.next();
                    }
                    intents++;//Augmentem el contador.
                } while (!dadaCorrecta && intents < INTENTS_MAX);//Mateix que l'anterior bucle.
                if (!dadaCorrecta) {
                    System.out.println("Has superat els intents, finalitzant programa...");
                }
            }
            intents = 0;//Reset dels intents una vegada arriba aqui.
            if (dadaCorrecta) {//Si la dada es correcta:
                do {
                    //Demanem nivell de prioritat i el guardem
                    System.out.println("Seleccioni el nivell de prioritat, (0) el mínim i (5) el màxim:");
                    dadaCorrecta = lector.hasNextInt();
                    if (dadaCorrecta) {
                        nivellPrioritat = lector.nextInt();
                        if ((nivellPrioritat < NIV_MIN) || (nivellPrioritat > NIV_MAX)) {
                            System.out.println("Error, nivell seleccionat incorrecte.");
                            dadaCorrecta = false;
                        } else {
                            intents = 0;//Reset intents.
                            do {
                                //Demanem temperatura i la guardem
                                System.out.println("Indiqui la temperatura corporal, temperatura vàlida entre 27 i 45 graus:");
                                dadaCorrecta = lector.hasNextInt();
                                if (dadaCorrecta) {
                                    temperaturaActual = lector.nextInt();
                                    if ((temperaturaActual < TEMP_MIN) || (temperaturaActual > TEMP_MAX)) {
                                        System.out.println("Error, temperatura incorrecta.");
                                        dadaCorrecta = false;
                                    }
                                } else {
                                    System.out.println("Dada incorrecta.");
                                    lector.next();
                                }
                                intents++;//Compte intents.
                            } while (!dadaCorrecta && intents < INTENTS_MAX);
                            if (!dadaCorrecta) {
                                System.out.println("Has superat els intents, finalitzant programa...");
                            }
                        }
                    } else {
                        System.out.println("Dada incorrecta.");
                        lector.next();
                    }
                    intents++;//Compte intents.
                } while (!dadaCorrecta && intents < INTENTS_MAX);
                if (!dadaCorrecta) {
                    System.out.println("Has superat els intents, finalitzant programa...");
                }
            }
            if (dadaCorrecta) {//Si tot es correcte:
                //Guardem dades al array
                tisArray[numPacients] = tis;
                simptomaArray[numPacients] = simptoma;
                exploracioArray[numPacients] = exploracio;
                nivellPrioritatArray[numPacients] = nivellPrioritat;
                temperaturaActualArray[numPacients] = temperaturaActual;
                tipusDolorArray[numPacients] = tipusDolor;
                tipusExploracioArray[numPacients] = tipusExploracio;
                numPacients++;//Augmenta el contador de pacients.
                System.out.println("S'han introduit: " + numPacients + " pacients.");
                System.out.println("Vols introduir un altre usuari?(Si:1 / No:0)");
                seguir = lector.nextInt(); //Pregunta si vol introduir més usuaris
                if (seguir != 1) { //Entra si la resposta no es 1
                    usuariNou = false;
                } else {
                    usuariNou = true;
                }
            } else {
                usuariNou = false;
            }
        } while (usuariNou);//Repeteix el bucle si vol introduir més usuaris
        //Mostra el llistat de tots els pacients
        System.out.println("Llistat de tots els pacients:");
        System.out.println("TIS\tSimptoma\tExploracio\tNivell prioritat\tTemperatura");
        for (int i = 0; i < numPacients; i++) {
            System.out.println(tisArray[i] + "\t" + tipusDolorArray[i] + "\t"
                    + tipusExploracioArray[i] + "\t" + nivellPrioritatArray[i] + "\t\t"
                    + temperaturaActualArray[i]);
        }
        //Pregunta si vol veure els pacients per simptoma
        System.out.println("Vols consultar per tipus de símptoma? (Si:1 / No:0)");
        seguir = lector.nextInt();
        if (seguir == 1) { //Entra si la resposta es 1
            //Demanarà per tipus de símptoma i mostrarà els pacients amb el tipus de símptoma especificat
            System.out.println("Quin tipus de símptoma? (0-3)");
            int tipusSintoma = lector.nextInt();
            System.out.println("Dades de pacients amb símptoma \"" + tipusSintoma + "\":");
            System.out.println("TIS\tSimptoma\tExploracio\tNivell prioritat\tTemperatura");
            for (int i = 0; i < numPacients; i++) {
                if (simptomaArray[i] == tipusSintoma) {
                    System.out.println(tisArray[i] + "\t" + tipusDolorArray[i] + "\t"
                            + tipusExploracioArray[i] + "\t" + nivellPrioritatArray[i] + "\t\t"
                            + temperaturaActualArray[i]);
                }
            }
        }
        //Pregunta si vol un resum estadístic de les dades
        System.out.println("Vols veure un resum estadístic de les dades? (Si:1 / No:0)");
        seguir = lector.nextInt();
        if (seguir == 1) { //Entra si la resposta es 1
            //Mostrarà un resum de les dades principals
            System.out.println("Número de pacients introduïts: " + numPacients);
            // Comptador per a cada simptoma
            int[] comptadorSimptomes = new int[4];
            for (int i = 0; i < numPacients; i++) {
                comptadorSimptomes[simptomaArray[i]]++;
            }
            // Comptador per a cada nivell de prioritat
            int[] comptadorPrioritat = new int[6];
            for (int i = 0; i < numPacients; i++) {
                comptadorPrioritat[nivellPrioritatArray[i]]++;
            }
            // Mostra els resultats
            for (int i = 0; i < 4; i++) {
                System.out.println("Número de pacients per Símptomes " + i + ": " + comptadorSimptomes[i]);
            }
            for (int i = 0; i < 6; i++) {
                System.out.println("Número de pacients per Nivell de prioritat " + i + ": " + comptadorPrioritat[i]);
            }
        }
    }
}

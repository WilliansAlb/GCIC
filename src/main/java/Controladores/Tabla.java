/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import POJOS.Variable;
import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author willi
 */
public class Tabla {

    public final int INT = 0;
    public final int STRING = 1;
    public final int DECIMAL = 2;
    public final int CHAR = 3;
    public final int BOOLEAN = 4;
    public final int ERROR = 5;
    public final int ERROR0 = 6;
    public final String IS = "INT";
    public final String SS = "STRING";
    public final String DS = "DECIMAL";
    public final String CS = "CHAR";
    public final String BS = "BOOLEAN";
    public final String ES = "ERROR";
    public final String[][] suma = {
        {IS, SS, DS, IS, IS},
        {SS, SS, SS, SS, ES},
        {DS, SS, DS, DS, DS},
        {IS, SS, DS, IS, IS},
        {IS, ES, DS, IS, BS}
    };
    public final String[][] resta = {
        {IS, ES, DS, IS, IS},
        {ES, ES, ES, ES, ES},
        {DS, ES, DS, DS, DS},
        {IS, ES, DS, IS, ES},
        {IS, ES, DS, ES, ES}
    };
    public final String[][] mult = {
        {IS, ES, DS, IS, IS},
        {ES, ES, ES, ES, ES},
        {DS, ES, DS, DS, DS},
        {IS, ES, DS, IS, IS},
        {IS, ES, DS, IS, BS}
    };
    public final String[][] div = {
        {DS, ES, DS, DS, IS},
        {ES, ES, ES, ES, ES},
        {DS, ES, DS, DS, DS},
        {DS, ES, DS, DS, IS},
        {DS, ES, DS, DS, ES}
    };

    public Tabla() {
    }

    public HashMap<String, Object> resultado_suma(HashMap<String, Object> izquierda, HashMap<String, Object> derecha) {
        HashMap<String, Object> retorno = new HashMap<>();
        retorno.put("tipo", ERROR);
        retorno.put("valor", null);
        int tipo1 = (int) izquierda.get("tipo");
        int tipo2 = (int) derecha.get("tipo");
        if (tipo1 == ERROR || tipo2 == ERROR) {
            retorno.put("valor", null);
        } else if (tipo1 == ERROR0 || tipo2 == ERROR0) {
            retorno.put("tipo", ERROR0);
        } else {
            String sumado = suma[tipo1][tipo2];
            switch (sumado) {
                case IS:
                    int numero1 = obtener_int(tipo1, izquierda);
                    int numero2 = obtener_int(tipo2, derecha);
                    retorno.put("tipo", INT);
                    retorno.put("valor", numero1 + numero2);
                    break;
                case SS:
                    retorno.put("tipo", STRING);
                    retorno.put("valor", izquierda.get("valor").toString() + derecha.get("valor").toString());
                    break;
                case DS:
                    double decimal1;
                    double decimal2;
                    double resultado;
                    if (tipo1 == DECIMAL) {
                        decimal1 = (double) izquierda.get("valor");
                    } else {
                        decimal1 = obtener_int(tipo1, izquierda);
                    }
                    if (tipo2 == DECIMAL) {
                        decimal2 = (double) derecha.get("valor");
                    } else {
                        decimal2 = obtener_int(tipo2, derecha);
                    }
                    resultado = decimal1 + decimal2;
                    retorno.put("tipo", DECIMAL);
                    retorno.put("valor", resultado);
                    break;
                case CS:
                    System.out.println("ninguno puede ser");
                    break;
                case BS:
                    boolean terminado = (boolean) izquierda.get("valor") || (boolean) derecha.get("valor");
                    retorno.put("tipo", BOOLEAN);
                    retorno.put("valor", terminado);
                    break;
                default:
                    break;
            }
        }
        return retorno;
    }

    public HashMap<String, Object> resultado_resta(HashMap<String, Object> izquierda, HashMap<String, Object> derecha) {
        HashMap<String, Object> retorno = new HashMap<>();
        retorno.put("tipo", ERROR);
        retorno.put("valor", null);
        int tipo1 = (int) izquierda.get("tipo");
        int tipo2 = (int) derecha.get("tipo");
        if (tipo1 == ERROR || tipo2 == ERROR) {
            retorno.put("valor", null);
        } else if (tipo1 == ERROR0 || tipo2 == ERROR0) {
            retorno.put("tipo", ERROR0);
        } else {
            String sumado = resta[tipo1][tipo2];
            switch (sumado) {
                case IS:
                    int numero1 = obtener_int(tipo1, izquierda);
                    int numero2 = obtener_int(tipo2, derecha);
                    retorno.put("tipo", INT);
                    retorno.put("valor", numero1 - numero2);
                    break;
                case SS:
                    System.out.println("ninguno puede ser");
                    break;
                case DS:
                    double decimal1;
                    double decimal2;
                    double resultado;
                    if (tipo1 == DECIMAL) {
                        decimal1 = (double) izquierda.get("valor");
                    } else {
                        decimal1 = obtener_int(tipo1, izquierda);
                    }
                    if (tipo2 == DECIMAL) {
                        decimal2 = (double) derecha.get("valor");
                    } else {
                        decimal2 = obtener_int(tipo2, derecha);
                    }
                    resultado = decimal1 - decimal2;
                    retorno.put("tipo", DECIMAL);
                    retorno.put("valor", resultado);
                    break;
                case CS:
                    System.out.println("ninguno puede ser");
                    break;
                case BS:
                    System.out.println("ninguno puede ser");
                    break;
                default:
                    break;
            }
        }
        return retorno;
    }

    public HashMap<String, Object> resultado_mult(HashMap<String, Object> izquierda, HashMap<String, Object> derecha) {
        HashMap<String, Object> retorno = new HashMap<>();
        retorno.put("tipo", ERROR);
        retorno.put("valor", null);
        int tipo1 = (int) izquierda.get("tipo");
        int tipo2 = (int) derecha.get("tipo");
        if (tipo1 == ERROR || tipo2 == ERROR) {
            retorno.put("valor", null);
        } else if (tipo1 == ERROR0 || tipo2 == ERROR0) {
            retorno.put("tipo", ERROR0);
        } else {
            String sumado = mult[tipo1][tipo2];
            switch (sumado) {
                case IS:
                    int numero1 = obtener_int(tipo1, izquierda);
                    int numero2 = obtener_int(tipo2, derecha);
                    retorno.put("tipo", INT);
                    retorno.put("valor", numero1 * numero2);
                    break;
                case SS:
                    System.out.println("ninguno puede ser");
                    break;
                case DS:
                    double decimal1;
                    double decimal2;
                    double resultado;
                    if (tipo1 == DECIMAL) {
                        decimal1 = (double) izquierda.get("valor");
                    } else {
                        decimal1 = obtener_int(tipo1, izquierda);
                    }
                    if (tipo2 == DECIMAL) {
                        decimal2 = (double) derecha.get("valor");
                    } else {
                        decimal2 = obtener_int(tipo2, derecha);
                    }
                    resultado = decimal1 * decimal2;
                    retorno.put("tipo", DECIMAL);
                    retorno.put("valor", resultado);
                    break;
                case CS:
                    System.out.println("ninguno puede ser");
                    break;
                case BS:
                    boolean terminado = (boolean) izquierda.get("valor") && (boolean) derecha.get("valor");
                    retorno.put("tipo", BOOLEAN);
                    retorno.put("valor", terminado);
                    break;
                default:
                    break;
            }
        }
        return retorno;
    }

    public HashMap<String, Object> resultado_div(HashMap<String, Object> izquierda, HashMap<String, Object> derecha) {
        HashMap<String, Object> retorno = new HashMap<>();
        retorno.put("tipo", ERROR);
        retorno.put("valor", null);
        int tipo1 = (int) izquierda.get("tipo");
        int tipo2 = (int) derecha.get("tipo");
        if (tipo1 == ERROR || tipo2 == ERROR) {
            retorno.put("valor", null);
        } else if (tipo1 == ERROR0 || tipo2 == ERROR0) {
            retorno.put("tipo", ERROR0);
        } else {
            String dividido = div[tipo1][tipo2];
            switch (dividido) {
                case IS:
                    int numero1 = obtener_int(tipo1, izquierda);
                    int numero2 = obtener_int(tipo2, derecha);
                    if (numero2 == 0) {
                        retorno.put("tipo", ERROR);
                    } else {
                        if (tipo1 == BOOLEAN || tipo2 == BOOLEAN) {
                            retorno.put("tipo", INT);
                            retorno.put("valor", (int) tipo1 / tipo2);
                        } else {
                            retorno.put("tipo", DECIMAL);
                            double ret = numero1 / numero2;
                            retorno.put("valor", ret);
                        }
                    }
                    break;
                case SS:
                    System.out.println("ninguno puede ser");
                    break;
                case DS:
                    double decimal1;
                    double decimal2;
                    double resultado;
                    if (tipo1 == DECIMAL) {
                        decimal1 = (double) izquierda.get("valor");
                    } else {
                        decimal1 = obtener_int(tipo1, izquierda);
                    }
                    if (tipo2 == DECIMAL) {
                        decimal2 = (double) derecha.get("valor");
                    } else {
                        decimal2 = obtener_int(tipo2, derecha);
                    }
                    if (decimal2 == 0) {
                        retorno.put("tipo", ERROR);
                    } else {
                        retorno.put("tipo", DECIMAL);
                        resultado = decimal1 / decimal2;
                        retorno.put("valor", resultado);
                    }
                    break;
                case CS:
                    System.out.println("ninguno puede ser");
                    break;
                case BS:
                    System.out.println("ninguno puede ser");
                default:
                    break;
            }
        }
        return retorno;
    }

    public HashMap<String, Object> resultado_or(HashMap<String, Object> izquierda, HashMap<String, Object> derecha) {
        HashMap<String, Object> retorno = new HashMap<>();
        retorno.put("tipo", ERROR);
        retorno.put("valor", null);
        System.out.println("or");
        int tipo1 = (int) izquierda.get("tipo");
        int tipo2 = (int) derecha.get("tipo");
        if (tipo1 == ERROR || tipo2 == ERROR) {
            retorno.put("valor", null);
        } else if (tipo1 == ERROR0 || tipo2 == ERROR0) {
            retorno.put("tipo", ERROR0);
        } else {
            if (tipo1 == tipo2) {
                if (tipo1 == BOOLEAN) {
                    boolean temp = izquierda.get("valor").toString().equalsIgnoreCase("true") || derecha.get("valor").toString().equalsIgnoreCase("true");
                    retorno.put("tipo", BOOLEAN);
                    retorno.put("valor", temp);
                } else {
                    retorno.put("tipo", ERROR);
                }
            } else {
                retorno.put("tipo", ERROR);
            }
        }
        return retorno;
    }

    public HashMap<String, Object> resultado_not(HashMap<String, Object> unico) {
        HashMap<String, Object> retorno = new HashMap<>();
        retorno.put("tipo", ERROR);
        retorno.put("valor", null);
        int tipo1 = (int) unico.get("tipo");
        if (tipo1 == BOOLEAN) {
            boolean dato = (boolean) unico.get("valor");
            retorno.put("tipo", BOOLEAN);
            retorno.put("valor", !dato);
        } else {
            switch (tipo1) {
                case ERROR0:
                    retorno.put("tipo", ERROR0);
                    retorno.put("valor", unico.get("valor"));
                    break;
                case ERROR:
                    retorno.put("valor", unico.get("valor"));
                    break;
                default:
                    retorno.put("valor", "no es un boolean");
                    break;
            }
        }
        return retorno;
    }

    public HashMap<String, Object> resultado_cambio(HashMap<String, Object> unico) {
        HashMap<String, Object> retorno = new HashMap<>();
        retorno.put("tipo", ERROR);
        retorno.put("valor", null);
        int tipo1 = (int) unico.get("tipo");
        if (tipo1 == INT || tipo1 == DECIMAL) {
            if (tipo1 == INT) {
                retorno.put("tipo", INT);
                int temp = (int) unico.get("valor");
                retorno.put("valor", -temp);
            } else {
                retorno.put("tipo", DECIMAL);
                double temp = (double) unico.get("valor");
                retorno.put("valor", -temp);
            }
        } else {
            switch (tipo1) {
                case ERROR0:
                    retorno.put("tipo", ERROR0);
                    retorno.put("valor", unico.get("valor"));
                    break;
                case ERROR:
                    retorno.put("valor", unico.get("valor"));
                    break;
                default:
                    retorno.put("valor", "no es un valor numerico");
                    break;
            }
        }
        return retorno;
    }

    public HashMap<String, Object> resultado_and(HashMap<String, Object> izquierda, HashMap<String, Object> derecha) {
        HashMap<String, Object> retorno = new HashMap<>();
        retorno.put("tipo", ERROR);
        retorno.put("valor", null);
        int tipo1 = (int) izquierda.get("tipo");
        int tipo2 = (int) derecha.get("tipo");
        if (tipo1 == ERROR || tipo2 == ERROR) {
            retorno.put("valor", null);
        } else if (tipo1 == ERROR0 || tipo2 == ERROR0) {
            retorno.put("tipo", ERROR0);
        } else {
            if (tipo1 == tipo2) {
                if (tipo1 == BOOLEAN) {
                    boolean temp = (boolean) izquierda.get("valor") && (boolean) derecha.get("valor");
                    retorno.put("tipo", BOOLEAN);
                    retorno.put("valor", temp);
                } else {
                    retorno.put("tipo", ERROR);
                }
            } else {
                retorno.put("tipo", ERROR);
            }
        }
        return retorno;
    }

    public HashMap<String, Object> resultado_ii(HashMap<String, Object> izquierda, HashMap<String, Object> derecha) {
        HashMap<String, Object> retorno = new HashMap<>();
        retorno.put("tipo", ERROR);
        retorno.put("valor", null);
        int tipo1 = (int) izquierda.get("tipo");
        int tipo2 = (int) derecha.get("tipo");
        if (tipo1 == ERROR || tipo2 == ERROR) {
            retorno.put("valor", null);
        } else if (tipo1 == ERROR0 || tipo2 == ERROR0) {
            retorno.put("tipo", ERROR0);
        } else {
            if ((tipo1 == DECIMAL && tipo2 == INT) || (tipo2 == DECIMAL && tipo1 == INT)) {
                boolean ret;
                if (tipo1 == tipo2) {
                    if (tipo1 == DECIMAL) {
                        ret = (double) izquierda.get("valor") == (double) derecha.get("valor");
                    } else {
                        ret = (int) izquierda.get("valor") == (int) derecha.get("valor");
                    }
                } else if (tipo1 == DECIMAL && tipo2 == INT) {
                    ret = (double) izquierda.get("valor") == (int) derecha.get("valor");
                } else {
                    ret = (int) izquierda.get("valor") == (double) derecha.get("valor");
                }
                retorno.put("tipo", BOOLEAN);
                retorno.put("valor", ret);
            } else {
                if (tipo1 == tipo2) {
                    if (izquierda.get("valor").equals(derecha.get("valor"))) {
                        retorno.put("tipo", BOOLEAN);
                        retorno.put("valor", true);
                    } else {
                        retorno.put("tipo", BOOLEAN);
                        retorno.put("valor", false);
                    }
                } else {
                    retorno.put("tipo", ERROR);
                    retorno.put("valor", "datos comparados incompatibles");
                }
            }
        }
        return retorno;
    }

    public HashMap<String, Object> resultado_dif(HashMap<String, Object> izquierda, HashMap<String, Object> derecha) {
        HashMap<String, Object> retorno = new HashMap<>();
        retorno.put("tipo", ERROR);
        retorno.put("valor", null);
        int tipo1 = (int) izquierda.get("tipo");
        int tipo2 = (int) derecha.get("tipo");
        if (tipo1 == ERROR || tipo2 == ERROR) {
            retorno.put("valor", null);
        } else if (tipo1 == ERROR0 || tipo2 == ERROR0) {
            retorno.put("tipo", ERROR0);
        } else {
            if ((tipo1 == DECIMAL && tipo2 == INT) || (tipo2 == DECIMAL && tipo1 == INT)) {
                boolean ret;
                if (tipo1 == tipo2) {
                    if (tipo1 == DECIMAL) {
                        ret = (double) izquierda.get("valor") != (double) derecha.get("valor");
                    } else {
                        ret = (int) izquierda.get("valor") != (int) derecha.get("valor");
                    }
                } else if (tipo1 == DECIMAL && tipo2 == INT) {
                    ret = (double) izquierda.get("valor") != (int) derecha.get("valor");
                } else {
                    ret = (int) izquierda.get("valor") != (double) derecha.get("valor");
                }
                retorno.put("tipo", BOOLEAN);
                retorno.put("valor", ret);
            } else {
                if (tipo1 == tipo2) {
                    if (!izquierda.get("valor").equals(derecha.get("valor"))) {
                        retorno.put("tipo", BOOLEAN);
                        retorno.put("valor", true);
                    } else {
                        retorno.put("tipo", BOOLEAN);
                        retorno.put("valor", false);
                    }
                } else {
                    retorno.put("tipo", ERROR);
                    retorno.put("valor", "datos comparados incompatibles");
                }
            }
        }
        return retorno;
    }

    public HashMap<String, Object> resultado_mayor(HashMap<String, Object> izquierda, HashMap<String, Object> derecha) {
        HashMap<String, Object> retorno = new HashMap<>();
        retorno.put("tipo", ERROR);
        retorno.put("valor", null);
        int tipo1 = (int) izquierda.get("tipo");
        int tipo2 = (int) derecha.get("tipo");
        System.out.println(tipo1 + "-" + tipo2);
        System.out.println(izquierda.get("valor").toString());
        if (tipo1 == ERROR || tipo2 == ERROR) {
            retorno.put("valor", null);
        } else if (tipo1 == ERROR0 || tipo2 == ERROR0) {
            retorno.put("tipo", ERROR0);
        } else {
            if ((tipo1 == DECIMAL || tipo1 == INT) && (tipo2 == DECIMAL || tipo2 == INT)) {
                boolean ret;
                if (tipo1 == tipo2) {
                    if (tipo1 == DECIMAL) {
                        ret = (double) izquierda.get("valor") > (double) derecha.get("valor");
                    } else {
                        ret = (int) izquierda.get("valor") > (int) derecha.get("valor");
                    }
                } else if (tipo1 == DECIMAL && tipo2 == INT) {
                    ret = (double) izquierda.get("valor") > (int) derecha.get("valor");
                } else {
                    ret = (int) izquierda.get("valor") > (double) derecha.get("valor");
                }
                retorno.put("tipo", BOOLEAN);
                retorno.put("valor", ret);
            } else {
                retorno.put("tipo", ERROR);
                retorno.put("valor", "Los datos ingresados no pueden ser comparados por el operador <=");
            }
        }
        return retorno;
    }

    public HashMap<String, Object> resultado_menor(HashMap<String, Object> izquierda, HashMap<String, Object> derecha) {
        HashMap<String, Object> retorno = new HashMap<>();
        retorno.put("tipo", ERROR);
        retorno.put("valor", null);
        int tipo1 = (int) izquierda.get("tipo");
        int tipo2 = (int) derecha.get("tipo");
        if (tipo1 == ERROR || tipo2 == ERROR) {
            retorno.put("valor", null);
        } else if (tipo1 == ERROR0 || tipo2 == ERROR0) {
            retorno.put("tipo", ERROR0);
        } else {
            if ((tipo1 == DECIMAL || tipo1 == INT) && (tipo2 == DECIMAL || tipo2 == INT)) {
                boolean ret;
                if (tipo1 == tipo2) {
                    if (tipo1 == DECIMAL) {
                        ret = (double) izquierda.get("valor") < (double) derecha.get("valor");
                    } else {
                        ret = (int) izquierda.get("valor") < (int) derecha.get("valor");
                    }
                } else if (tipo1 == DECIMAL && tipo2 == INT) {
                    ret = (double) izquierda.get("valor") < (int) derecha.get("valor");
                } else {
                    ret = (int) izquierda.get("valor") < (double) derecha.get("valor");
                }
                retorno.put("tipo", BOOLEAN);
                retorno.put("valor", ret);
            } else {
                retorno.put("tipo", ERROR);
                retorno.put("valor", "Los datos ingresados no pueden ser comparados por el operador <=");
            }
        }
        return retorno;
    }

    public int obtener_int(int tipo, HashMap<String, Object> valor) {
        int retorno = -1;
        switch (tipo) {
            case INT:
                retorno = (int) valor.get("valor");
                break;
            case CHAR:
                char temp = (char) valor.get("valor");
                retorno = (int) temp;
                break;
            case BOOLEAN:
                retorno = (boolean) valor.get("valor") ? 1 : 0;
                break;
            default:
                break;
        }
        return retorno;
    }

    public void asc(String palabra) {
        Variable retorno = new Variable();
        retorno.letpar_num(palabra);
        retorno.letimpar_num(palabra);
    }
}

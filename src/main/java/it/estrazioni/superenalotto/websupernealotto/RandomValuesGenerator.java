package it.estrazioni.superenalotto.websupernealotto;

import it.estrazioni.superenalotto.Estraction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/createRandom")
public class RandomValuesGenerator extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public RandomValuesGenerator() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int randomJsp = 0;
        for (int i = 0; i <= 6; i++) {
            if(request.getAttribute("num" + i) == null){
                request.setAttribute("num" + i, "");
            }
            randomJsp = (int) (Math.random() * 90) + 1;
            request.setAttribute("random" + i, randomJsp);
        }
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] arrayStringJson;
        String msg = "";
        String json = request.getParameter("json");
        Integer[] arrayInt = new Integer[6];
        if (json != null && json != "") {
            json = json.substring(1, json.length() - 1);
            json = json.replaceAll("\"", "");
            arrayStringJson = json.split(",");
            System.out.println(arrayStringJson);
            for (int i = 0; i <= 5; i++) {
                int value = Integer.parseInt(arrayStringJson[i]);
                arrayInt[i] = value;
            }
            try {
                if (!nonDuplicateValues(arrayInt)) {
//                    request.setAttribute("errorMessage", "You don't have to enter duplicates or 0! ");
                    msg = "\"You don't have to enter duplicates or 0!\"";
                } else {
                    boolean result = Estraction.comparatorTest(arrayInt);
                    Arrays.sort(arrayInt);
                    String arrayString = Arrays.toString(arrayInt);
                    if (result) {
//                        request.setAttribute("validation", " The sextin " + arrayString + " that you entered corresponds to the one on the database ");
                        msg = "\" The sextin " + arrayString + " that you entered corresponds to the one on the database \"";
                        response.getWriter().write(" msg: " + msg);
                    } else {
//                        request.setAttribute("validation", " The sextin " + arrayString + " that you entered corresponds to the one on the database");
                        msg = "\" The sextin " + arrayString + " that you entered corresponds to the one on the database \"";
                        response.getWriter().write(msg);
                    }
                }

                for (int x = 1; x <= 6; x++)
                    request.setAttribute("num" + x, arrayInt[x - 1]);
            } catch (Exception e) {
                for (int i = 0; i <= 6; i++) {
                    request.setAttribute("num" + i, "0");
                }
                e.printStackTrace();
//                request.setAttribute("error", " An error has occurred ");
                msg = "{\"1\":\" Error... An unexpected problem occurred :(  \"}";
                response.getWriter().write(" msg: " + msg);
            }
        } else {
            arrayInt = Estraction.randomValues();
            response.getWriter().write(Arrays.toString(arrayInt));
        }

//        String generator = request.getParameter("equalsName");
//        int[] estraction = new int[6];
//        response.getWriter().write(json);
    }

    public static boolean nonDuplicateValues(Integer[] arrayInt) {
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] == 0) {
                return false;
            } else {
                for (int j = 0; j < i; j++) {
                    if (arrayInt[j] == arrayInt[i]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int[] stringToInt(String[] array) {
        int[] arrayInt = new int[6];
        for (int i = 0; i < array.length; i++) {
            arrayInt[i] = Integer.parseInt(array[i]);
        }
        Arrays.sort(arrayInt);
        return arrayInt;
    }

    public static String[] intToString(int[] array) {
        String[] arrayString = new String[6];
        for (int i = 0; i < array.length; i++) {
            arrayString[i] = String.valueOf(array[i]).toString();
        }
        return arrayString;
    }

//    public static void randomMethod(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        int []array =  null;
//        String random = (String)request.getParameter("randomValues");
//        if("CreateRandom".equals(random)) {
//            array = Estraction.numeriCasuali();
//            request.setAttribute("n1", array[0]);
//            request.setAttribute("n2", array[1]);
//            request.setAttribute("n3", array[2]);
//            request.setAttribute("n4", array[3]);
//            request.setAttribute("n5", array[4]);
//            request.setAttribute("n6", array[5]);
//        }
//
//        String convalidate = (String) request.getParameter("MyNumbers");
//        if("Compare my numbers".equals(convalidate)) {
//            String[] arrayString=intToString(array);
//            if( ) {
//                String test = "work";
//                request.setAttribute("working", test);
//            }
//        }
//        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
//        view.forward(request, response);
//        HttpSession session = request.getSession();
//        session.setAttribute("sexstin", array );
//    }

}

package it.estrazioni.superenalotto;

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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int randomJsp = 0;
        for(int index = 0; index <= 6; index++){
            if(request.getAttribute("num" + index) == null)
                request.setAttribute("num" + index, "");
            randomJsp = (int) (Math.random() * 90) + 1;
            request.setAttribute("random" + index, randomJsp);
        }
        RequestDispatcher view = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] arrayStringJson;
        String msg = "";
        String json = request.getParameter("json");
        Integer[] arrayInt = new Integer[6];
        if(json != null && json != ""){
            json.substring(1, json.length() - 1);
            json = json.replaceAll("\"", "");
            arrayStringJson = json.split(",");
            System.out.println(arrayStringJson);

            for(int index = 0; index <= 5; index++){
                int value = Integer.parseInt(arrayStringJson[index]);
                arrayInt[index] = value;
            }
            try{
                if(numeriNonDuplicati(arrayInt) == false){
//                    request.setAttribute("errorMessage", "Non devi inserire duplicati o 0! ");
                    msg = "\"Non devi inserire duplicati o 0! \"";
                    response.getWriter().write(msg);
                }else{
                    boolean result = Estrazione.testComparatore(arrayInt);
                    Arrays.sort(arrayInt);
                    String arrayString = Arrays.toString(arrayInt);
                    if(result){
//                        request.setAttribute("validation", "La sestina" + arrayString + " che hai inserito non corrisponde a quella della base dati ");
                        msg = "\"La sestina " + arrayString + " che hai inserito corrisponde a quella sulla base dati \"";
                        response.getWriter().write(msg);
                    }else{
//                        request.setAttribute("validation", "La sestina" + arrayString + " che hai inserito non corrisponde a quella della base dati "):
                        msg = "\"La sestina" + arrayString + " che hai inserito non corrisponde a quella della base dati \"";
                    }
                }

                for(int x = 1; x <= 6; x++){
                    request.setAttribute("num" + x, arrayInt[x - 1]);
                }
            }
            catch(Exception e){
                for(int index = 0; index <= 6; index++){
                    request.setAttribute("num" + index, "0");
                }
                e.printStackTrace();
//                request.setAttribute("error", "Si è verificato un errore");
                mess = {}
            }
        }
    }
}

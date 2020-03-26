package it.estrazioni.superenalotto.struts;

import com.opensymphony.xwork2.ActionSupport;
import it.estrazioni.superenalotto.Estraction;
import it.estrazioni.superenalotto.hibernate.BaseObjectImpl;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.util.Arrays;

@ParentPackage("json-default")
public class StrutsClass extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private Integer[] arrayInt;
    private String result;
    BaseObjectImpl boImpl = new BaseObjectImpl();

    public Integer[] getArrayInt() {
        return arrayInt;
    }

    public void setArrayInt(Integer[] arrayInt) {
        this.arrayInt = arrayInt;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Action(value = "/lotto", results = {@Result(name = "success", location = "/WEB-INF/content/jsp/struts.jsp")})
    public String init(){
        return "success";
    }
    @Action (value ="/valida" ,interceptorRefs= {@InterceptorRef("json")}, results= {@Result(name="success" , type="json")})
    public String validation()throws Exception{
        String msg = "";
        if (arrayInt != null) {
            try {
                if (notDuplicatedValues(arrayInt) == false) {
                    msg="Non devi inserire duplicati o 0 ";
                    setResult(msg);
                } else {
                    boolean esito = boImpl.convalidate(arrayInt);
                    Arrays.sort(arrayInt);
                    String arrayString = Arrays.toString(arrayInt);
                    if (esito) {
                        msg="La sestina" + arrayString+ "che hai inserito Corrisponde a quella sul DataBase ";
                        setResult(msg);
                    } else {
                        msg="La sestina" + arrayString+ "che hai inserito NON Corrisponde a quella sul DataBase";
                        setResult(msg);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                msg = "Erroe si è verificato un problema inaspettato :(  ";
                setResult(msg);
            }

        }else
            setResult("Occhio ai null");
        return SUCCESS;
    }


    @Action (value ="/genera" , results= {@Result(name="success" , type="json")})
    public String generaSestina()throws Exception{
        arrayInt = Estraction.randomValues();
        return SUCCESS;
    }

    public static boolean notDuplicatedValues(Integer[] arrayInt2) {
        for (int i = 0; i < arrayInt2.length; i++) {
            if (arrayInt2[i] == 0) {
                return false;
            } else {
                for (int j = 0; j < i; j++) {
                    if (arrayInt2[j].equals(arrayInt2[i])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

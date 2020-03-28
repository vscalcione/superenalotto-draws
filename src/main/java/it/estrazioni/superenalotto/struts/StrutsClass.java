package it.estrazioni.superenalotto.struts;

import com.opensymphony.xwork2.ActionSupport;
import it.estrazioni.superenalotto.Estraction;
import it.estrazioni.superenalotto.hibernate.bo.BoImpl;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import java.util.Arrays;

@ParentPackage("json-default")
public class StrutsClass extends ActionSupport{

    private static final long serialVersionUID = 1L;
    private Integer[] arrayInt;
    private String result;
    BoImpl boImpl = new BoImpl();

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

    @Action(value = "/lotto", results =  {@Result(name = "success", location = "/WEB-INF/content/jsp/struts.jps")})
    public String init(){
        return "success";
    }

    @Action (value = "/validate", interceptorRefs = {@InterceptorRef("json")}, results = {@Result(name = "success" , type="json")})
    public String validation() throws Exception{
        String msg = "";
        if (arrayInt != null) {
            try {
                if (!nonDuplicateNumbers(arrayInt)) {
                    msg = " You don't have to enter duplicates or 0 ";
                    setResult(msg);
                } else {
                    boolean result = boImpl.convalidate(arrayInt);
                    Arrays.sort(arrayInt);
                    String arrayString = Arrays.toString(arrayInt);
                    if (result) {
                            msg = " The sextin " + arrayString+ " that you entered corresponds to the one on the database ";
                        setResult(msg);
                    } else {
                        msg = " The sextin " + arrayString+ " that you entered not corresponds to the one on the database";
                        setResult(msg);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                    msg = "Error ... An unexpected problem occurred :( ";
                setResult(msg);
            }
        }else {
            setResult("Beware of null values!! ");
        }
        return SUCCESS;
    }

    @Action (value = "/generate" , results= {@Result(name = "success" , type="json")})
    public String generateSestina() throws Exception{
        arrayInt = Estraction.randomValues();
        return SUCCESS;
    }

    public static boolean nonDuplicateNumbers(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                return false;
            } else {
                for (int j = 0; j < i; j++) {
                    if (array[j] == array[i])
                        return false;
                }
            }
        }
        return true;
    }
}

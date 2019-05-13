/**
 * The class that prints the error to the cashier.
 * @Author Netanel Avraham Eklind
 * */

package se.kth.iv1350.pos.view;
 class ErrorMessageHandler {

    private String newLine = System.getProperty("line.separator");

    /**
     * The method responsible for printing the error message.
     * @param msg                       contains the <code> String </code> that
     *                                  the <code>{@link se.kth.iv1350.pos.dbhandler.InvalidIDException}</code>
     *                                  gives.
     * */
    void printMessage(String msg){
        StringBuilder sb = new StringBuilder();
        sb.append("ERROR"+newLine);
        sb.append(msg);
        System.out.println(sb);
    }
}

/**
 * The class that prints the error to the cashier.
 * The following line of code have been inspired by the course book about object
 * oriented development
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

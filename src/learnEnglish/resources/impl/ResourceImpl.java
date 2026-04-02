package learnEnglish.resources.impl;

public class ResourceImpl implements learnEnglish.resources.Resource {
    @Override
    public void loading() throws InterruptedException {

        System.out.println("\n\n"+
                           "\t .....10%.....");Thread.sleep(130);
        System.out.println("\t .....25%.....");Thread.sleep(100);
        System.out.println("\t .....35%.....");Thread.sleep(150);
        System.out.println("\t .....47%.....");Thread.sleep(220);
        System.out.println("\t .....60%.....");Thread.sleep(110);
        System.out.println("\t .....72%.....");Thread.sleep(100);
        System.out.println("\t .....80%.....");Thread.sleep(250);
        System.out.println("\t .....100%....."+
                         "\n\n\n\n\n\n");

    }
}

package app.management.prototype;

import java.io.IOException;

public abstract class AccountAcademics extends AccountParent {
	
       @Override
       public double getAmountToBePaid()
       {
           return super.amountToBePaid*0.85;
       }

     

    public AccountAcademics(int aa) throws IOException {
        super(aa);
    }
	
	


}
package info.apatrix.foodapp.app;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by pc on 20-Oct-18.
 */

public class Fontt {
    Context context;
    public Fontt(Context context) {
        this.context = context;
    }

    public  Typeface bold = Typeface.createFromAsset(context.getAssets(),  "fonts/Poppins-Bold.ttf");
    public  Typeface regular = Typeface.createFromAsset(context.getAssets(),  "fonts/Poppins-Regular.ttf");
    public   Typeface semi_bold = Typeface.createFromAsset(context.getAssets(),  "fonts/Poppins-SemiBold.ttf");
}

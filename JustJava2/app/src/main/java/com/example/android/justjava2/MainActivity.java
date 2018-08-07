/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/
package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.justjava2.R;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int  quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
//        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
//        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
//        EditText text = (EditText)findViewById(R.id.name_field);
//        String nameEntered = text.getText().toString();
//        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
//        boolean hasChocolate = chocolateCheckBox.isChecked();
//        int price = calculatePrice(hasWhippedCream , hasChocolate);
//        String priceMessage = createOrderSummary(price , hasWhippedCream , hasChocolate , nameEntered);
//        displayMessage(priceMessage);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:47.6, -122.3"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public String createOrderSummary(int price, boolean addWhippedCream , boolean addChocolate , String namegot) {
        String Message = "Name: " +  namegot + "\n";
        Message = Message + "Add whipped cream?" + addWhippedCream + "\n";
        Message = Message + "Add Chocolate?" + addChocolate + "\n";
        Message = Message + "Quantity: " + quantity + "\n";
        Message = Message +"Total: $" + price  +"\n";
        Message = Message + "Thank You!";
        return Message;
    }


    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice( boolean hasWhippedCream , boolean hasChocolate) {
        int basePrice = 5;
        if(hasWhippedCream)
            basePrice = basePrice + 1;
        if(hasChocolate)
            basePrice = basePrice + 2;
        return quantity * basePrice;
    }

    public void increment(View view) {
        if(quantity == 100)
        {
            Toast.makeText(this, "You cannot have more than 100 coffees",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity=quantity+1;
        displayQuantity(quantity);
    }
    public void decrement(View view) {
        if(quantity == 0)
        {
            Toast.makeText(this, "You cannot have less than 1 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity=quantity-1;
        displayQuantity(quantity);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}

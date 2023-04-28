package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView input_text,output_text;
    private String input,output,newoutput;
    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonadd,buttonmultiply,buttonsubs,
    buttondiv,buttonpoint,buttonpower,buttonequal,buttonclear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_text=findViewById(R.id.input_text);
        output_text=findViewById(R.id.output_text);

        button0=findViewById(R.id.btn0);
        button1=findViewById(R.id.btn1);
        button2 =findViewById(R.id.btn2);
        button3=findViewById(R.id.btn3);
        button4=findViewById(R.id.btn4);
        button5 =findViewById(R.id.btn5);
        button6=findViewById(R.id.btn6);
        button7=findViewById(R.id.btn7);
        button8=findViewById(R.id.btn8);
        button9=findViewById(R.id.btn9);
        buttonadd=findViewById(R.id.addition_btn);
        buttonmultiply=findViewById(R.id.multiply_btn);
        buttondiv =findViewById(R.id.division_btn);
        buttonclear=findViewById(R.id.clear_btn);
        buttonsubs=findViewById(R.id.subtraction_btn);
        buttonpoint=findViewById(R.id.point_btn);
        buttonpower=findViewById(R.id.power_btn);
        buttonequal=findViewById(R.id.equal_btn);


    }
    public void onButtonClicked(View view){
        Button button=(Button) view;
        String data=button.getText().toString();
        switch (data){
            case "C":
                input=null;
                output=null;
                newoutput=null;
                output_text.setText("");
                break;

            case "^":
                solve();
                input +="^";

                break;

            case "*":
                solve();
                input +="*";

                break;
            case "=":
                solve();
                input +="";

                break;
            case "%":
                input +="%";
                double d=Double.parseDouble(input_text.getText().toString())/100;
                output_text.setText(String.valueOf(d));
                break;
            default:
                if(input==null){
                    input=" ";

                }
                if(data.equals("+") || data.equals("-") || data.equals("/") ){
                    solve();
                }
                input +=data;
        }
        input_text.setText(input);
    }
    private void solve(){
        if(input.split("\\+").length==2);{
            String number[]=input.split("\\+");

                try{
                    double d=Double.parseDouble(number[0])+ Double.parseDouble(number[1]);
                    output=Double.toString(d);
                    output_text.setText(output);
                    newoutput=cutDecimal(output);
                    output_text.setText(newoutput);
                    input=d+"";
                }catch (Exception e){
                    //output_text.setError(e.getMessage().toString());
                }


        }
        if(input.split("\\*").length==2);{
            String number[]=input.split("\\*");

            try{
                double d=Double.parseDouble(number[0])* Double.parseDouble(number[1]);
                output=Double.toString(d);
                output_text.setText(output);
                newoutput=cutDecimal(output);
                output_text.setText(newoutput);
                input=d+"";
            }catch (Exception e){
               // output_text.setError(e.getMessage().toString());
            }


        }
        if(input.split("\\/").length==2);{
            String number[]=input.split("\\/");

            try{
                double d=Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                output=Double.toString(d);
                output_text.setText(output);
                newoutput=cutDecimal(output);
                output_text.setText(newoutput);
                input=d+"";
            }catch (Exception e){
               // output_text.setError(e.getMessage().toString());
            }


        }
        if(input.split("\\^").length==2);{
            String number[]=input.split("\\^");

            try{
                double d=Math.pow(Double.parseDouble(number[0]),Double.parseDouble(number[1]));
                output=Double.toString(d);
                output_text.setText(output);
                newoutput=cutDecimal(output);
                output_text.setText(newoutput);
                input=d+"";
            }catch (Exception e){
               // output_text.setError(e.getMessage().toString());
            }


        }
        if(input.split("\\-").length==2);{
            String number[]=input.split("\\-");

            try{
                if(Double.parseDouble(number[0])<Double.parseDouble(number[1])){
                    double d=Double.parseDouble(number[1])- Double.parseDouble(number[0]);
                    output=Double.toString(d);
                    newoutput=cutDecimal(output);
                    output_text.setText("-"+newoutput);
                    input=d+"";
                }else {
                    double d=Double.parseDouble(number[0])- Double.parseDouble(number[1]);
                    output=Double.toString(d);
                    newoutput=cutDecimal(output);
                    output_text.setText(newoutput);
                    input=d+"";
                }

            }catch (Exception e){
               // output_text.setError(e.getMessage().toString());
            }


        }
    }
    private String cutDecimal(String number) {
        String n[] = number.split("\\.");
        if (n.length > 1) {
            if (n[1].equals("0")) {
                number = n[0];
            }
        }

        return number;
    }

}
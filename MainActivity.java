package aidafakhry.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.graphics.Color;
import android.widget.ImageButton;
import android.widget.TextView;

import android.os.Bundle;

import java.util.Scanner;
/* ref. from https://stackoverflow.com/questions/36595845/add-radio-buttons-to-if-statement
       ceaser cipher: https://javahungry.blogspot.com/2019/02/caesar-cipher-program-in-java.html
       encrypt: https://www.thejavaprogrammer.com/caesar-cipher-java-encryption-decryption/
       Vignere: https://javahungry.blogspot.com/2019/12/vigenere-cipher-in-java.html
       Scytale cipher: https://codereview.stackexchange.com/questions/249051/implementation-of-scytale-cipher-encryption-and-decryption

       KEY:
       Encrypt - one rice
       Decrypt - two rice
       */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioButton[] buttons = new RadioButton[3];
    ImageButton[] button = new ImageButton[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttons[0] = (RadioButton) this.findViewById(R.id.scytalecipher);
        buttons[1] = (RadioButton) this.findViewById(R.id.caesarcipher);
        buttons[2] = (RadioButton) this.findViewById(R.id.vigenerecipher);
        for (int a = 0; a < buttons.length; a++) {
            System.out.println(a);
            buttons[a].setOnClickListener(this);
            buttons[a].setEnabled(true);
            buttons[a].setBackgroundColor(Color.LTGRAY);             //setting the background color of the buttons

        }
        //encrypt and decrypt buttons: set them/ask users if they want them... image buttons
        button[0] = (ImageButton) this.findViewById(R.id.imageButton1); //encrypt
        button[1] = (ImageButton) this.findViewById(R.id.imageButton2); //decrypt
        for (int m = 0; m < button.length; m++) {
            System.out.println(m);
            button[m].setOnClickListener(this);
           // button[m].setEnabled(true);
        }
    }

    @Override
    public void onClick(View view) {
        if (buttons[0].isChecked() && button[0] == view) {
            //scytale and encrypt: FIX!
            EditText messageet = (EditText) findViewById(R.id.Mytext2); //asking for the input
            String message = messageet.getText().toString();
            EditText rows2 = (EditText) findViewById(R.id.Mytext3); //ASKING FOR THE ROWS
            int rows = Integer.parseInt(rows2.getText().toString());
            message = message.replace("", "");
            message = message.toUpperCase();
            String originalMessage = message;
            while (message.length() % rows != 0) {
                message += '@';
            }
            int numberOfExtra = message.length() - originalMessage.length();
            int columns = message.length() / rows;
            char[][] encryptedMessage = new char[rows][columns];
            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if ((i >= rows - numberOfExtra) && (j == columns - 1)) {
                        encryptedMessage[i][j] = '@';
                    } else if (index < originalMessage.length()) {
                        encryptedMessage[i][j] = originalMessage.charAt(index);
                        index++;
                    }
                }
            }
            String encrypted = "";
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    encrypted += encryptedMessage[j][i];
                }
                EditText output1 = (EditText) findViewById(R.id.output);
                output1.setText(String.valueOf(encrypted) + "");
            }
            //scytale and decrypt
            if (buttons[0].isChecked() && button[1] == view) {
                EditText message2= (EditText)findViewById(R.id.Mytext2);
                String messagetwo = message2.getText().toString();
                int rows3 =  Integer.parseInt(message2.getText().toString());
                messagetwo = messagetwo.replace(" ", "");
                messagetwo = messagetwo.toUpperCase();
                while (messagetwo.length() % rows3 != 0) {
                    messagetwo += "@";
                }
                int columns1 = messagetwo.length() / rows3;
                char[][] decryptedMessage = new char[rows3][columns1];
                int index1 = 0;
                for (int i = 0; i < columns1; i++) {
                    for (int j = 0; j < rows3; j++) {
                        if (index1 < messagetwo.length()) {
                            decryptedMessage[j][i] = messagetwo.charAt(index1);
                            index1++;
                        }
                    }
                }
                String decrypted = "";
                for (int i = 0; i < rows3; i++) {
                    for (int j = 0; j < columns1; j++) {
                        if (decryptedMessage[i][j] != '@') { //remove extra characters
                            decrypted += decryptedMessage[i][j];
                        }
                        EditText output2 = (EditText) findViewById(R.id.output);
                        output2.setText(String.valueOf(decrypted) + "");
                    }
                }
            }
        }
        else if (buttons[1].isChecked() && button[0] == view) { //CEASER AND ENCRYPT
            //ENCRYPT
            EditText message3= (EditText)findViewById(R.id.Mytext2);
            String messagethree = message3.getText().toString();
            EditText int2 = (EditText)findViewById(R.id.Mytext4);
            messagethree = messagethree.replace(" ", "");
            messagethree = messagethree.toUpperCase();
            String encrypted = "";
            int shift =  Integer.parseInt(int2.getText().toString()); //geting shifts
            String ciphertext = "";
            char alphabet;
            for (int i = 0; i < messagethree.length(); i++) {
                // Shift one character at a time
                alphabet = messagethree.charAt(i);
                // if alphabet lies between a and z
                if (alphabet >= 'a' && alphabet <= 'z') {
                    // shift alphabet
                    alphabet = (char) (alphabet + shift);
                    // if shift alphabet greater than 'z'
                    if (alphabet > 'z') {
                        // reshift to starting position
                        alphabet = (char) (alphabet + 'a' - 'z' - 1);
                    }
                    ciphertext = ciphertext + alphabet;
                } else if (alphabet >= 'A' && alphabet <= 'Z') {
                    alphabet = (char) (alphabet + shift);
                    if (alphabet > 'Z') {
                        alphabet = (char) (alphabet + 'A' - 'Z' - 1);
                    }
                    ciphertext = ciphertext + alphabet;
                } else {
                    ciphertext = ciphertext + alphabet;
                }
                EditText output3 = (EditText)findViewById(R.id.output);
                output3.setText(String.valueOf(ciphertext) + "");
            }
        } else if (buttons[1].isChecked() && button[1] == view) { //CEASER AND DECRYPT - ERROR

            String message, decryptedMessage = "";
            char ch;
            EditText value = (EditText)findViewById(R.id.Mytext2);
            String message4 = value.getText().toString();
            //getting key:
            EditText key4 = (EditText)findViewById(R.id.Mytext4);
            int key =  Integer.parseInt(key4.getText().toString()); //geting shifts
            for (int i = 0; i < message4.length(); ++i) {
                ch = message4.charAt(i);
                if (ch >= 'a' && ch <= 'z') {
                    ch = (char) (ch - key);
                    if (ch < 'a') {
                        ch = (char) (ch + 'z' - 'a' + 1);
                    }
                    decryptedMessage += ch;
                } else if (ch >= 'A' && ch <= 'Z') {
                    ch = (char) (ch - key);

                    if (ch < 'A') {
                        ch = (char) (ch + 'Z' - 'A' + 1);
                    }
                    decryptedMessage += ch;
                } else {
                    decryptedMessage += ch;
                }
            }
            EditText output4 = (EditText)findViewById(R.id.output);
            output4.setText(String.valueOf(decryptedMessage) + "");

        }

        //ENCRYPT and DECRYPT DONE
        else if (buttons[2].isChecked() && button[0] == view) { // vigenere  encrypt
            EditText message5 = (EditText)findViewById(R.id.Mytext2); //called text - > message 5
            String value = message5.getText().toString();
            EditText keyword = (EditText)findViewById(R.id.Mytext5);
            String keyword5 = keyword.getText().toString();
            char msg[] = value.toCharArray();
            int msgLen = msg.length;
            int i, j;
// Creating new char arrays
            char key[] = new char[msgLen];
            char encryptedMsg[] = new char[msgLen];
            for (i = 0, j = 0; i < msgLen; ++i, ++j) {
                if (j == keyword.length()) {
                    j = 0;
                }
                key[i] = keyword5.charAt(j);
            }
            for (i = 0; i < msgLen; ++i)
                encryptedMsg[i] = (char) (((msg[i] + key[i]) % 26) + 'A');
            //decryption code
            System.out.println("Original Message: " + value);
            System.out.println("Keyword: " + keyword);
            System.out.println("Key: " + String.valueOf(key));
            System.out.println();
            System.out.println("Encrypted Message: " + String.valueOf(encryptedMsg));
            System.out.println();
            EditText output5 = (EditText)findViewById(R.id.output);
            output5.setText(String.valueOf(encryptedMsg) + "");

        } else if (buttons[2].isChecked() && button[1] == view) { //vigenere decrypt
            EditText message6 = (EditText)findViewById(R.id.Mytext2);
            String values = message6.getText().toString().toUpperCase();
            EditText keyword6 = (EditText)findViewById(R.id.Mytext5);
            String keywords = keyword6.getText().toString().toUpperCase();
            String decryptedMsg = "";


            for (int i = 0, j = 0; i < values.length(); i++) {
                char c = values.charAt(i);
                if (c < 'A' || c > 'Z') continue;
                decryptedMsg += (char)((c - keywords.charAt(j) + 26) % 26 + 'A');
                j = ++j % keywords.length();
            }

            //printing to screen

            EditText output6 = (EditText)findViewById(R.id.output);
            output6.setText(String.valueOf(decryptedMsg) + "");



        }
    }

}
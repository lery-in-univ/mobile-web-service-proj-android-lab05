package com.example.lab05;

import android.os.Bundle;
import android.util.Pair;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.NumberFormat;
import java.util.Optional;

public class MainActivity extends AppCompatActivity {
    private FourBasicOpt opt;

    private EditText editText_firstNumber;
    private EditText editText_secondNumber;

    private TextView text_expression;
    private TextView text_result;
    private TextView text_errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        opt = new FourBasicOpt();

        editText_firstNumber = findViewById(R.id.editText_firstNumber);
        editText_secondNumber = findViewById(R.id.editText_secondNumber);

        text_expression = findViewById(R.id.text_expression);
        text_result = findViewById(R.id.text_result);
        text_errorMessage = findViewById(R.id.text_errorMessage);

        clearError();

        findViewById(R.id.btn_add).setOnClickListener((view) -> onPressAddButton());
        findViewById(R.id.btn_subtract).setOnClickListener((view) -> onPressSubtractButton());
        findViewById(R.id.btn_multiply).setOnClickListener((view) -> onPressMultiplyButton());
        findViewById(R.id.btn_divide).setOnClickListener((view) -> onPressDivideButton());
    }

    private void onPressAddButton() {
        clearError();

        Optional<InputNumber> rawInputNumber = getInputNumbers();
        if (rawInputNumber.isEmpty()) {
            showError("입력한 값에 문제가 있습니다.");
            return;
        }

        InputNumber inputNumber = rawInputNumber.get();
        int result = opt.add(inputNumber.first, inputNumber.second);

        text_result.setText(String.valueOf(result));
        text_expression.setText(String.format("%d + %d", inputNumber.first, inputNumber.second));
    }

    private void onPressSubtractButton() {
        clearError();

        Optional<InputNumber> rawInputNumber = getInputNumbers();
        if (rawInputNumber.isEmpty()) {
            showError("입력한 값에 문제가 있습니다.");
            return;
        }

        InputNumber inputNumber = rawInputNumber.get();
        int result = opt.subtract(inputNumber.first, inputNumber.second);

        text_result.setText(String.valueOf(result));
        text_expression.setText(String.format("%d - %d", inputNumber.first, inputNumber.second));
    }

    private void onPressMultiplyButton() {
        clearError();

        Optional<InputNumber> rawInputNumber = getInputNumbers();
        if (rawInputNumber.isEmpty()) {
            showError("입력한 값에 문제가 있습니다.");
            return;
        }

        InputNumber inputNumber = rawInputNumber.get();
        int result = opt.multiply(inputNumber.first, inputNumber.second);

        text_result.setText(String.valueOf(result));
        text_expression.setText(String.format("%d * %d", inputNumber.first, inputNumber.second));
    }

    private void onPressDivideButton() {
        clearError();

        Optional<InputNumber> rawInputNumber = getInputNumbers();
        if (rawInputNumber.isEmpty()) {
            showError("입력한 값에 문제가 있습니다.");
            return;
        }

        InputNumber inputNumber = rawInputNumber.get();
        int result = opt.divide(inputNumber.first, inputNumber.second);

        text_result.setText(String.valueOf(result));
        text_expression.setText(String.format("%d / %d", inputNumber.first, inputNumber.second));
    }

    private Optional<InputNumber> getInputNumbers() {
        String firstNumberStr = editText_firstNumber.getText().toString();
        String secondNumberStr = editText_secondNumber.getText().toString();

        try {
            int firstNumber = Integer.parseInt(firstNumberStr);
            int secondNumber = Integer.parseInt(secondNumberStr);

            return Optional.of(new InputNumber(firstNumber, secondNumber));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    private void showError(String message) {
        text_errorMessage.setText(message);
    }

    private void clearError() {
        text_errorMessage.setText("");
    }

    private class InputNumber {
        private int first;
        private int second;

        InputNumber(int first, int second) {
            this.first = first;
            this.second = second;
        }

        int getFirst() {
            return first;
        }

        int getSecond() {
             return second;
        }
    }
}
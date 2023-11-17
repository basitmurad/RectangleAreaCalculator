package com.basit.rectangleareacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.basit.rectangleareacalculator.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        setButtonClickListeners();


        binding.bac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.obtained.setText("");
                binding.total.setText("");
                binding.answer.setText("");
//                binding.tvsec.setText("");
            }
        });


        binding.btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the values from the obtained and total EditText fields
                String obtainedValue = binding.obtained.getText().toString().trim();
                String totalValue = binding.total.getText().toString().trim();

                // Check if either obtained or total value is empty
                if (obtainedValue.isEmpty() || totalValue.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Enter both length and total width", Toast.LENGTH_SHORT).show();
                    return;
                } else {
//                    double obtainedValue1 = Double.parseD(binding.obtained.getText().toString().trim());
                    double doubleValue1 = Double.parseDouble(binding.obtained.getText().toString().trim());
                    double doubleValue3 = Double.parseDouble(binding.total.getText().toString().trim());


                    double area = doubleValue1 * doubleValue3;

                    binding.answer.setText("Area is " +area);
                    Toast.makeText(MainActivity.this, "" + area, Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

        private void setButtonClickListeners() {
            // Set click listeners for numeric buttons
            binding.b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appendTextFromButton("1");
                }
            });

            binding.b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appendTextFromButton("2");
                }
            });

            binding.b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appendTextFromButton("3");
                }
            });

            binding.b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appendTextFromButton("4");
                }
            });



            binding.b5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appendTextFromButton("5");
                }
            });

            binding.b6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appendTextFromButton("6");
                }
            });

            binding.b7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appendTextFromButton("7");
                }
            });

            binding.b8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appendTextFromButton("8");
                }
            });

            binding.b9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appendTextFromButton("9");
                }
            });

            binding.b0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appendTextFromButton("0");
                }
            });






            binding.btnDot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    appendTextFromButton(".");
//                Toast.makeText(MainActivity.this, "Basit", Toast.LENGTH_SHORT).show();
                }
            });

            binding.obtained.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        binding.obtained.setInputType(InputType.TYPE_NULL);
                        binding.bc.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (binding.obtained != null) {
                                    String val = binding.obtained.getText().toString();
                                    if (!val.isEmpty()) {
                                        val = val.substring(0, val.length() - 1);
                                        binding.obtained.setText(val);
                                    }
                                }
                            }
                        });
                        hideKeyboard();
                    }
                }
            });
            binding.total.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View v, boolean hasFocus) {
                    if (hasFocus) {
                        binding.total.setInputType(InputType.TYPE_NULL);


                        binding.bc.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (binding.total != null) {
                                    String val = binding.total.getText().toString();
                                    if (!val.isEmpty()) {
                                        val = val.substring(0, val.length() - 1);
                                        binding.total.setText(val);
                                    }
                                }
                            }
                        });
                        hideKeyboard();
                    }
                }
            });

        }

        // Method to append text from buttons to the EditText
        private void appendTextFromButton(String buttonText) {
            // Find the focused EditText
            EditText focusedEditText = getFocusedEditText();

            if (focusedEditText != null) {
                // Get the current cursor position
                int cursorPosition = focusedEditText.getSelectionStart();

                // Insert the button text at the current cursor position
                focusedEditText.getText().insert(cursorPosition, buttonText);
            }
        }

        // Method to determine the focused EditText
        private EditText getFocusedEditText() {
            if (binding.obtained.hasFocus()) {

                hideKeyboard();
                return binding.obtained;
            } else if (binding.total.hasFocus()) {
                hideKeyboard();
                return binding.total;
            } else {
                // If neither has focus, you can choose a default or handle it as needed
                return null;
            }
        }

        private void hideKeyboard() {
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }



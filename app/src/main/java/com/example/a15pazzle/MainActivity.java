package com.example.a15pazzle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.*;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.a15pazzle.R.id;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;


public class MainActivity extends AppCompatActivity {
    int handnum = 0;//これは手数を数えるための変数
    int winkaisu;//成功回数を数える
    final int[] point = new int[16];
    int buttonnum = 0;
    SharedPreferences pref;
    SharedPreferences.Editor prefEdit;
    List<Integer> list = new ArrayList<>();
     Button[] button = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // Toast.makeText(getApplicationContext(),"onCreate",Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("main", MODE_PRIVATE);
        prefEdit = pref.edit();
        final TextView te = (TextView) findViewById(R.id.te);
        //final TextView winnum = (TextView) findViewById(R.id.winnum);
        Button b1 = (Button) findViewById(id.bu1);
        Button b2 = (Button) findViewById(R.id.bu2);
        Button b3 = (Button) findViewById(R.id.bu3);
        Button b4 = (Button) findViewById(R.id.bu4);
        Button b5 = (Button) findViewById(R.id.bu5);
        Button b6 = (Button) findViewById(R.id.bu6);
        Button b7 = (Button) findViewById(R.id.bu7);
        Button b8 = (Button) findViewById(R.id.bu8);
        Button b9 = (Button) findViewById(R.id.bu9);
        Button b10 = (Button) findViewById(R.id.bu10);
        Button b11 = (Button) findViewById(R.id.bu11);
        Button b12 = (Button) findViewById(R.id.bu12);
        Button b13 = (Button) findViewById(R.id.bu13);
        Button b14 = (Button) findViewById(R.id.bu14);
        Button b15 = (Button) findViewById(R.id.bu15);
        Button b16 = (Button) findViewById(R.id.bu16);
        Button restart = (Button) findViewById(R.id.restart);
        Button save = (Button) findViewById(R.id.save);
        button = new Button[]{b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16};
        Random r = new Random();


        shuffle(te);
        //盤面は位置が済ん�?ところで
        //�?キスト�?�力をした�?で�?
        button[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (point[1] == 0) change(0, 1,  te);
                else if (point[4] == 0) change(0, 4,  te);
                else show();
            }
        });

        button[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (point[0] == 0) change(1, 0,  te);
                else if (point[2] == 0) change(1, 2,  te);
                else if (point[5] == 0) change(1, 5,  te);
                else show();

            }
        });

        button[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (point[1] == 0) change(2, 1,  te);
                else if (point[6] == 0) change(2, 6,  te);
                else if (point[3] == 0) change(2, 3,  te);
                else show();
            }
        });

        button[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (point[2] == 0) {
                    change(3, 2,  te);
                } else if (point[7] == 0) {
                    change(3, 7,  te);
                } else {
                    show();
                }
            }
        });

        button[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (point[0] == 0) {
                    change(4, 0,  te);
                } else if (point[5] == 0) {
                    change(4, 5,  te);
                } else if (point[8] == 0) {
                    change(4, 8,  te);
                } else {
                    show();
                }
            }
        });

        button[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (point[4] == 0) {
                    change(5, 4,  te);
                } else if (point[1] == 0) {
                    change(5, 1,  te);
                } else if (point[6] == 0) {
                    change(5, 6,  te);
                } else if (point[9] == 0) {
                    change(5, 9,  te);
                } else {
                    show();
                }
            }
        });

        button[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (point[2] == 0) {
                    change(6, 2,  te);
                } else if (point[5] == 0) {
                    change(6, 5, te);
                } else if (point[7] == 0) {
                    change(6, 7,  te);
                } else if (point[10] == 0) {
                    change(6, 10,  te);
                } else {
                    show();
                }
            }
        });

        button[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (point[3] == 0) {
                    change(7, 3,  te);
                } else if (point[6] == 0) {
                    change(7, 6,  te);
                } else if (point[11] == 0) {
                    change(7, 11,  te);
                } else {
                    show();
                }
            }
        });

        button[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (point[4] == 0) {
                    change(8, 4, te);
                } else if (point[9] == 0) {
                    change(8, 9, te);
                } else if (point[12] == 0) {
                    change(8, 12,  te);
                } else {
                    show();
                }
            }
        });

        button[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (point[5] == 0) {
                    change(9, 5,  te);
                } else if (point[8] == 0) {
                    change(9, 8,  te);
                } else if (point[10] == 0) {
                    change(9, 10, te);
                } else if (point[13] == 0) {
                    change(9, 13,  te);
                } else {
                    show();
                }
            }
        });

        button[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (point[6] == 0) {
                    change(10, 6, te);
                } else if (point[9] == 0) {
                    change(10, 9, te);
                } else if (point[11] == 0) {
                    change(10, 11, te);
                } else if (point[14] == 0) {
                    change(10, 14, te);
                } else {
                    show();
                }
            }
        });

        button[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (point[7] == 0) {
                    change(11, 7, te);
                } else if (point[10] == 0) {
                    change(11, 10, te);
                } else if (point[15] == 0) {
                    change(11, 15, te);
                } else {
                    show();
                }
            }
        });

        button[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (point[8] == 0) {
                    change(12, 8, te);
                } else if (point[13] == 0) {
                    change(12, 13, te);
                } else {
                    show();
                }
            }
        });

        button[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (point[9] == 0) {
                    change(13, 9, te);
                } else if (point[12] == 0) {
                    change(13, 12, te);
                } else if (point[14] == 0) {
                    change(13, 14, te);
                } else {
                    show();
                }
            }
        });

        button[14].setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (point[15] == 0) {
                    change(14, 15, te);
                } else if (point[10] == 0) {
                    change(14, 10, te);
                } else if (point[13] == 0) {
                    change(14, 13, te);
                } else {
                    show();
                }
            }
        });

        button[15].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (point[11] == 0) {
                    change(15, 11, te);
                } else if (point[14] == 0) {
                    change(15, 14, te);
                } else {
                    show();
                }
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            //�?り直し�?�タン
            //盤面をシャ�?フルしなおす
            @Override
            public void onClick(View v) {
                shuffle(te);
            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TITLE, "puzzle.txt");
                startActivityForResult(intent, 1);
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onActivityResult(int a, int b, Intent c) {
        super.onActivityResult(a, b, c);

        Uri uri = Objects.requireNonNull(c.getData());
        if (a == 1 && b == RESULT_OK) {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    getContentResolver().openOutputStream(uri)))) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        String s1 = Integer.toString(point[i * 4 + j]);
                        if (s1.equals("0")) writer.write("   ");
                        else {
                            if (s1.length() == 2) writer.write(" " + s1 + "");
                            else writer.write(" " + s1 + " ");
                        }
                    }
                    writer.write("\n");
                }
            } catch (Exception io) {
                //どんなエラーが�?�るかもわからね�?し�?�っち�?けException�?けでよくね?�?
                Toast.makeText(getApplicationContext(), "a", Toast.LENGTH_SHORT).show();
            }
        }
    }


    void show() {
        Toast.makeText(getApplicationContext(), "操作できません", Toast.LENGTH_SHORT).show();
    }

    boolean check(int[] point) {
        if (point[0] == 0) {
            for (int i = 0; i < 15; i++) {
                if (point[i] != i) return false;
            }
        } else if (point[15] == 0) {
            for (int i = 14; i >= 0; i--) {
                if (point[i] != i + 1) return false;
            }
        } else return false;

        return true;
    }

    void shuffle(TextView te) {
        String[] str = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
        Random r = new Random();
        list.clear();
        for (; list.size() < 16;) {
            int num = r.nextInt(16);
            if (!list.contains(num)) list.add(num);
            else continue;
        }

        try {
            for (int i = 0; i < 16; i++) {
                //0-14コ
                String s = str[list.get(i)];
                if (Integer.parseInt(s) == 0) {
                    button[i].setText("");
                    point[i] = Integer.parseInt(s);
                } else {
                    point[i] = Integer.parseInt(s);
                    button[i].setText(s);
                }
            }
            //catchで強制�?に画面が消えな�?ように制御
        } catch (NullPointerException nul) {
            Toast.makeText(getApplicationContext(), "era", Toast.LENGTH_SHORT).show();
        } catch (ArrayIndexOutOfBoundsException a) {
            Toast.makeText(getApplicationContext(), "a", Toast.LENGTH_SHORT).show();
        } catch (Exception a) {
            Toast.makeText(getApplicationContext(), "e", Toast.LENGTH_SHORT).show();
        }
        handnum = 0;
        te.setText(Integer.toString(handnum));
        buttonnum = 0;
    }

    void change(int x, int y,TextView te) {
        //ここでマスを�?�れ替える
        if (!check(point)) {
            //左側に押したボタンの座標な
            handnum++;
            int a = point[x];
            point[x] = point[y];
            point[y] = a;
            String sx = Integer.toString(point[x]);
            String sy = Integer.toString(point[y]);
            button[x].setText(" ");
            button[y].setText(sy);
            handinc(te);
        } else {
            //クリアしたら何もしな�?
        }
        //入れ替わるた�?�にクリアチェ�?クを行う
        if (check(point) && buttonnum == 0) {
            winkaisu++;
            Toast.makeText(getApplicationContext(), "成功です�??�??�??�?", Toast.LENGTH_LONG).show();
            TextView tew = (TextView) findViewById(R.id.winnum);
            tew.setText(Integer.toString(winkaisu));
            buttonnum++;
        } else if (!check(point)) {
            //Toast.makeText(getApplicationContext(), "�?り直�?", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "クリアチェ�?ク済み", Toast.LENGTH_SHORT).show();
        }
    }

    void handinc(TextView te) {
        handnum += 1;
        te.setText(Integer.toString(handnum / 2));
    }

    @Override
    public void onPause() {
        //画面を閉じるときに保�?
        super.onPause();
        TextView win = (TextView) findViewById(R.id.winnum);
        prefEdit.putInt("main", winkaisu);
        prefEdit.commit();
    }

    @Override
    public void onResume() {
        //画面を立ち上げた時に出�?
        super.onResume();
        TextView winnum = (TextView) findViewById(R.id.winnum);
        int strtext = pref.getInt("main", winkaisu);
        winkaisu = strtext;
        winnum.setText(Integer.toString(strtext));
    }
}
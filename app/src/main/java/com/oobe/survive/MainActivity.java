package com.oobe.survive;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jp.wasabeef.recyclerview.animators.FadeInRightAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RVAdapter adapter;
    int next = 0;
    int colorcount = 0;
    public node tree[] = new node[201];
    ArrayList<node> datalist = new ArrayList<>();
    public Button cBtn;
    int[] colors = {Color.rgb(0x3F, 0x51, 0xB5), Color.rgb(0xFF, 0x57, 0x22), Color.rgb(0x21, 0x21, 0x21), Color.rgb(0x00, 0x96, 0x88)};
    float[] ele = {30, 0};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);

        SlideInUpAnimator animator = new SlideInUpAnimator();
        animator.setAddDuration(200);
        animator.setRemoveDuration(200);
        recyclerView.setItemAnimator(animator);

        adapter = new RVAdapter(this);
        recyclerView.setAdapter(adapter);

        cBtn = (Button) findViewById(R.id.continueBtn);

        tree[0] = new node("You are Taylor", 1, -1, 1, false, "", "");
        tree[1] = new node("You arrive at the Kempegowda International airport...", 2, -1, -1, false, "", "");
        tree[2] = new node("You’re a backpacker from the US, NYC.", 3, -1, -1, false, "", "");
        tree[3] = new node("Here in India, The mysterious land, looking for an adventure…", 4, -1, -1, false, "", "");
        tree[4] = new node("After heading out of the airport, you have to cross the road to get a cab.", 5, -1, -1, false, "", "");
        tree[5] = new node("Cross the road when...", 6, -1, -1, false, "", "");
        tree[6] = new node("", 8, 7, -1, true, "Pedestrian signal is red, and there’s no incoming traffic.", "Wait for it to turn green, and then cross.");
        tree[7] = new node("A speeding truck jumps the red light, hits you and you die…", 200, -1, -1, false, "", "");
        tree[8] = new node("You reach the other side, and get a taxi. You ask for his recommendation for a hotel to stay.", 9, -1, -1, false, "", "");
        tree[9] = new node("He takes you to a sketchy place.", 10, -1, -1, false, "", "");
        tree[10] = new node("", 11, 13, -1, true, "Choose to go there", "Go to another place using google map suggestions");
        tree[11] = new node("The quality of the place is poor. Service is bad. There are insects and rats in the room.", 12, -1, -1, false, "", "");
        tree[12] = new node("Couldn’t get proper sleep, wakes up tired and gloomy. Definitely not going to come back here.", 15, -1, -1, false, "", "");
        tree[13] = new node("Finds a decent place.", 14, -1, -1, false, "", "");
        tree[14] = new node("Gets good sleep, and is energized for the adventure.", 15, -1, -1, false, "", "");
        tree[15] = new node("It’s a bright and wonderful morning.", 16, -1, -1, false, "", "");
        tree[16] = new node("Decides to visit an old friend from India", 17, -1, -1, false, "", "");
        tree[17] = new node("You walk outside, see a broken footpath and busy road. Where do you walk?", 18, -1, -1, false, "", "");
        tree[18] = new node("", 19, 20, -1, true, "Walk on the footpath", "Take the road");
        tree[19] = new node("Motorcyclist takes the footpath and runs over you!", 200, -1, -1, false, "", "");
        tree[20] = new node("Get a autorickshaw and reach friend's place safely", 21, -1, -1, false, "", "");
        tree[21] = new node("Friend's very warm and welcoming. Offers tea and breakfast", 22, -1, -1, false, "", "");
        tree[22] = new node("Friend suggests you to go to Bannerghatta Zoo or Nandi hills.", 23, -1, -1, false, "", "");
        tree[23] = new node("Where would you like to go?", 24, -1, -1, false, "", "");
        tree[24] = new node("", 25, 34, -1, true, "Let's see the zoo", "Head to the Hills!");
        tree[25] = new node("Travel to the zoo by bus. Really far away from the city. Reach there 2 hours later", 26, -1, -1, false, "", "");
        tree[26] = new node("Lots of garbage dumped all over the place. Disgusting experience to see such a side of the city", 27, -1, -1, false, "", "");
        tree[27] = new node("Enter the zoo. Amazed to see elephants, tigers and other animals. Enjoyed the safri too.", 28, -1, -1, false, "", "");
        tree[28] = new node("Exit the zoo. Terrifying news...", 29, -1, -1, false, "", "");
        tree[29] = new node("A leapord escaped out of the zoo and is roaming wildly in neighbouring areas.", 30, -1, -1, false, "", "");
        tree[30] = new node("Worse news... Leapord seems to be overly hungry due to poor care taken at the zoo! What do you do?", 31, -1, -1, false, "", "");
        tree[31] = new node("", 200, 200, -1, true, "GO Hide! ", "Jump on to a moving bus");
        tree[32] = new node("Peek-a-Bo! Leapord found you!!! You'll give him a taste of American Cuisine!", 200, -1, -1, false, "", "");
        tree[33] = new node("Bus was overcrowded.. You couldn't board it.! You fall down...Head Down!!", 200, -1, -1, false, "", "");
        tree[34] = new node("Spend time til noon with friend. You get to see the great Indian husband-wife War! ", 35, -1, -1, false, "", "");
        tree[35] = new node("Have late lunch and leave to Nandi hills by private van", 36, -1, -1, false, "", "");
        tree[36] = new node("Reached there to see beautiful sunset.. Clicked amazing pics of the sunset", 37, -1, -1, false, "", "");
        tree[37] = new node("How'll you go back?", 38, -1, -1, false, "", "");
        tree[38] = new node("", 41, 39, -1, true, "Take a taxi", "Return in the same van");
        tree[39] = new node("The van get punctured while descending the hill", 40, -1, -1, false, "", "");
        tree[40] = new node("Van slips and falls into a valley", 200, -1, -1, false, "", "");
        tree[41] = new node("Driver drops your friend at his home. Takes you back to hotel.. All alone", 42, -1, -1, false, "", "");
        tree[42] = new node("Driver drives you all around Bangalore. Spins a single round-about thrice. After a really long while..", 43, -1, -1, false, "", "");
        tree[43] = new node("Stops finally in the middle of a isolated barren land.! It's almost midnight", 44, -1, -1, false, "", "");
        tree[44] = new node("Threatens you with a knife and asks you to pay up $100", 45, -1, -1, false, "", "");
        tree[45] = new node("( You're trained in martial arts. But the driver is 2 times your size ). What do you do?", 46, -1, -1, false, "", "");
        tree[46] = new node("", 47, 49, -1, true, "Refuse to pay. Fight him!!", "Pay and reach hotel safely");
        tree[47] = new node("Never underestimate of an Indian guy! Aah! He just stabbed me!!", 48, -1, -1, false, "", "");
        tree[48] = new node("You bleed to death and there's no one to help you...", 200, -1, -1, false, "", "");
        tree[49] = new node("You decide to pay him anyway.. Just to be safe!", 50, -1, -1, false, "", "");
        tree[50] = new node("AH! Finally reached hotel safely..!", 51, -1, -1, false, "", "");
        tree[51] = new node("DaMn! I've lost all my luggage..! Luckily i had my passport and flight tickets with me..", 52, -1, -1, false, "", "");
        tree[52] = new node("Missing 'Murica! I'm Going back home right away..", 200, -1, -1, false, "", "");
        tree[200] = new node(" Wasted !", 199, -1, -1, false, "", "");
        tree[199] = new node("Play again?", 198, -1, -1, false, "", "");
        tree[198] = new node("", 0, 303, -1, true, "Yes !", "I'm done exploring..");
        datalist.add(tree[0]);
        adapter.addItem(tree[0], datalist.size());

        cBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datalist.add(tree[next]);
                adapter.addItem(tree[next], datalist.size());
                next = tree[next].lindex;
                recyclerView.scrollToPosition(datalist.size() - 1);
                if (tree[next].btn) {
                    cBtn.setVisibility(View.INVISIBLE);
                } else {
                    cBtn.setVisibility(View.VISIBLE);
                }
            }

        });
    }

    public class RVAdapter extends RecyclerView.Adapter<RVAdapter.MyViewHolder> {

        private LayoutInflater layoutInflater;

        public RVAdapter(Context context) {

            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = layoutInflater.inflate(R.layout.list_item_row, parent, false);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, int position) {
            holder.msg.setText(tree[next].msg);
            holder.cardView.setCardBackgroundColor(colors[(colorcount) % 4]);
            holder.cardView.setCardElevation(ele[(colorcount++)%2]);
            if (tree[next].btn) {
                holder.leftBtn.setVisibility(View.VISIBLE);
                holder.rightBtn.setVisibility(View.VISIBLE);
            } else {
                holder.leftBtn.setVisibility(View.GONE);
                holder.rightBtn.setVisibility(View.INVISIBLE);
            }

            holder.leftBtn.setText(tree[next].leftBtnmsg);
            holder.rightBtn.setText(tree[next].rightBtnmsg);
            holder.rightBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    next = tree[next].rindex;
                    datalist.add(tree[next]);
                    adapter.addItem(tree[next], datalist.size());
                    recyclerView.scrollToPosition(datalist.size() - 1);
                    if (tree[next].btn) {
                        cBtn.setVisibility(View.INVISIBLE);
                    } else {
                        cBtn.setVisibility(View.VISIBLE);
                    }
                }
            });
            holder.leftBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    next = tree[next].lindex;
                    datalist.add(tree[next]);
                    adapter.addItem(tree[next], datalist.size());
                    recyclerView.scrollToPosition(datalist.size() - 1);
                    if (tree[next].btn) {
                        cBtn.setVisibility(View.INVISIBLE);
                    } else {
                        cBtn.setVisibility(View.VISIBLE);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return datalist.size();
        }

        public void addItem(node addObj, int pos) {

            notifyItemInserted(pos - 1);
            recyclerView.scrollToPosition(pos);
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView msg;
            Button leftBtn, rightBtn;
            CardView cardView;

            public MyViewHolder(View itemView) {
                super(itemView);

                msg = (TextView) itemView.findViewById(R.id.msg);
                leftBtn = (Button) itemView.findViewById(R.id.left_btn);
                rightBtn = (Button) itemView.findViewById(R.id.right_btn);
                cardView = (CardView) itemView.findViewById(R.id.cv);

            }
        }


    }
}

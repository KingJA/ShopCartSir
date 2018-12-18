package sample.kingja.shopcartsir;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;


/**
 * Description:TODO
 * Create Time:2018/1/22 16:01
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class GoodsAdapter extends BaseLvAdapter<Item> {

    public GoodsAdapter(Context context, List<Item> list) {
        super(context, list);
    }

    @Override
    public View simpleGetView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View
                    .inflate(context, R.layout.item_shopcart, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final Item item = (Item) getItem(position);

        viewHolder.tv_count.setText(String.valueOf(item.getCount()));
        viewHolder.iv_reduce.setVisibility(item.getCount() > 0 ? View.VISIBLE : View.GONE);
        viewHolder.iv_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = item.getCount();
                if (count < 1) {
                    return;
                }
                count--;

                if (count == 0) {
                    animClose(viewHolder.iv_reduce);
//                    viewHolder.iv_reduce.setVisibility(View.GONE);
                }
                item.setCount(count);
                notifyDataSetChanged();

            }
        });
        viewHolder.iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = item.getCount();
                count++;
                item.setCount(count);
                notifyDataSetChanged();
                if (count == 1) {
                    viewHolder.iv_reduce.setVisibility(View.VISIBLE);
                    animOpen(viewHolder.iv_reduce);
                }
            }
        });
        return convertView;
    }

    public void animOpen(final ImageView imageView) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator translationAnim = ObjectAnimator.ofFloat(imageView, "translationX", 200, 0);
        ObjectAnimator rotationAnim = ObjectAnimator.ofFloat(imageView, "rotation", 0, 720);
        animatorSet.play(translationAnim).with(rotationAnim);
        animatorSet.setDuration(500).start();
    }


    public void animClose(final ImageView imageView) {
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator translationAnim = ObjectAnimator.ofFloat(imageView, "translationX", 0, 200);
        ObjectAnimator rotationAnim = ObjectAnimator.ofFloat(imageView, "rotation", 0, 720);
        animatorSet.play(translationAnim).with(rotationAnim);
//        animatorSet.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                imageView.setVisibility(View.GONE);
//            }
//        });
        animatorSet.setDuration(500).start();

    }

    @Override
    public int getCount() {
        return list.size();
    }

    public class ViewHolder {
        public final View root;
        ImageView iv_reduce;
        ImageView iv_add;
        TextView tv_count;

        public ViewHolder(View root) {
            this.root = root;
            iv_reduce = root.findViewById(R.id.iv_reduce);
            iv_add = root.findViewById(R.id.iv_add);
            tv_count = root.findViewById(R.id.tv_count);
        }
    }

}

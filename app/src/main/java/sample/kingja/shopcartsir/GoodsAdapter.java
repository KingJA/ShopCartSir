package sample.kingja.shopcartsir;

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
        ViewHolder viewHolder;
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
        viewHolder.iv_reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = item.getCount();
                item.setCount(--count);
                notifyDataSetChanged();
            }
        });
        viewHolder.iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = item.getCount();
                item.setCount(++count);
                notifyDataSetChanged();


            }
        });
        return convertView;
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

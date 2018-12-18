package sample.kingja.shopcartsir;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Description:TODO
 * Create Time:2018/12/18 22:51
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public class ShopCartView extends LinearLayout {
    public ShopCartView(Context context) {
        this(context, null);
    }

    public ShopCartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShopCartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initShopCartView();
    }

    private void initShopCartView() {

    }
}

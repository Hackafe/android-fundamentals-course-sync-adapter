package org.hackafe.syncadapter;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.ContentResolver;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        attachHandlers(findViewById(android.R.id.content));
    }

    private void attachHandlers(View root) {
        if (root instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) root;
            for (int i=0; i<group.getChildCount(); i++)
                attachHandlers(group.getChildAt(i));
        } else if (root instanceof Button) {
            root.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        AccountManager am = AccountManager.get(this);
        Account geno = new Account("geno", "regular.hackafe.org");
        String authority = "hackafe.org";

        switch (v.getId()) {
            case R.id.force_sync:
                ContentResolver.requestSync(
                        geno,
                        authority,
                        new Bundle());
                break;
            case R.id.set_auto:
                ContentResolver.setSyncAutomatically(
                        geno, authority, true
                );
                break;
            case R.id.set_manual:
                ContentResolver.setSyncAutomatically(
                        geno, authority, true
                );
                break;
            case R.id.set_periodic:
                ContentResolver.addPeriodicSync(
                        geno, authority, new Bundle(), 30
                );
                break;
        }
    }
}

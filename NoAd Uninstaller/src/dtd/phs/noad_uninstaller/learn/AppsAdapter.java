package dtd.phs.noad_uninstaller.learn;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import dtd.phs.lib.utils.Helpers;
import dtd.phs.noad_uninstaller.R;

public class AppsAdapter extends BaseAdapter {

	private static final int GREY = 0xfff2f2f2;
	private List<PHS_AppInfo> apps;
	private Context context;

	public AppsAdapter(Context context, List<PHS_AppInfo> appsInfo) {
		this.apps = appsInfo;
		this.context = context;
	}

	@Override
	public int getCount() {
		if ( apps == null ) return 0;
		return apps.size();
	}

	@Override
	public PHS_AppInfo getItem(int position) {
		return apps.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = Helpers.inflate(context, R.layout.app_item, null);
		TextView name = (TextView) v.findViewById(R.id.appName);
		name.setText(getItem(position).getAppName());
		ImageView icon = (ImageView) v.findViewById(R.id.icon);
		icon.setImageDrawable(getItem(position).getIcon());
		if ( position % 2 == 0 ) 
			v.setBackgroundColor(GREY);
		return v;
	}

}
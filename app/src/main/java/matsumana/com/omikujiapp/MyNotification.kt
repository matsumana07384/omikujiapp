package matsumana.com.omikujiapp


import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationCompat.PRIORITY_MAX
import android.support.v4.app.TaskStackBuilder

// 参考
// https://developer.android.com/guide/topics/ui/notifiers/notifications?hl=ja

class MyNotification
/**
 * MyNotificationクラスのコンストラクタ
 * @param context 通知元
 * @param resultActivity 通知をタップした際に開くアクティビティのクラス
 */
constructor(context: Context, resultActivity: Class<*> = context.javaClass) {

    private var context: Context? = null
    private var resultActivity: Class<*>? = null

    private val notificationId = 1
    private val requestCode = 0

    internal var channelId = "channeld"
    internal var defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
    internal var title = "タイトル"
    internal var text = "テキスト"
    internal var icon = R.drawable.ic_launcher_foreground

    init {
        this.context = context
        this.resultActivity = resultActivity
    }

    fun run() {
        val builder = NotificationCompat.Builder(context!!, channelId)
                .setSound(defaultSoundUri)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(icon)
                .setPriority(PRIORITY_MAX) // 通知の優先度を最高に設定

        // 明示的インテント
        val resultIntent = Intent(context, resultActivity)

        context?.let {
            val stackBuilder = TaskStackBuilder.create(it)
            stackBuilder.addParentStack(it.javaClass)
            // スタックの最初に実装するActivityを追加
            stackBuilder.addNextIntent(resultIntent)
            val resultPendingIntent = stackBuilder.getPendingIntent(
                    requestCode,
                    PendingIntent.FLAG_UPDATE_CURRENT
            )
            builder.setContentIntent(resultPendingIntent)
            val notificationManager = it.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            // notificationIdを利用して通知をアップデート可能
            notificationManager.notify(notificationId, builder.build())
        }
    }
}

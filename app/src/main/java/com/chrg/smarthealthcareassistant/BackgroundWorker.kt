package com.chrg.smarthealthcareassistant

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.view.LayoutInflater
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.dialog_box.view.*
import java.io.*
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder


class BackgroundWorker
internal constructor(var context: Context) : AsyncTask<String?, Void?, String>() {

    var alertDialog: AlertDialog? = null
    var result: String? = ""
    var line: String? = ""

    override fun doInBackground(vararg params: String?): String? {

        val type = params[0]
        val loginUrl = "http://192.168.43.94/tutorialDB/login.php"
        val registerUrl = "http://192.168.43.94/tutorialDB/register.php"
        val editDataUrl = "http://192.168.43.94/tutorialDB/editData.php"
        val viewDataUrl = "http://192.168.43.94/tutorialDB/userDataView.php"

        if (type == "login") {
            try {
                val userName = params[1]
                val password = params[2]
                val url = URL(loginUrl)
                val httpURLConnection = url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod = "POST"
                httpURLConnection.doOutput = true
                httpURLConnection.doInput = true
                val outputStream = httpURLConnection.outputStream
                val bufferedWriter = BufferedWriter(OutputStreamWriter(outputStream, "UTF-8"))
                val postData = URLEncoder.encode(
                    "user_name",
                    "UTF-8"
                ) + "=" + URLEncoder.encode(
                    userName,
                    "UTF-8"
                ) + "&" + URLEncoder.encode(
                    "password",
                    "UTF-8"
                ) + "=" + URLEncoder.encode(password, "UTF-8")
                bufferedWriter.write(postData)
                bufferedWriter.flush()
                bufferedWriter.close()
                outputStream.close()
                val inputStream = httpURLConnection.inputStream
                val bufferedReader = BufferedReader(InputStreamReader(inputStream, "iso-8859-1"))
                while (bufferedReader.readLine().also { line = it } != null) {
                    result+=line
                }
                bufferedReader.close()
                inputStream.close()
                httpURLConnection.disconnect()

                //                return result;
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        }
        else if (type == "register") {
            try {
                val userName = params[1]
                val email = params[2]
                val password = params[3]
                val phone = params[4]
                val url = URL(registerUrl)
                val httpURLConnection = url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod = "POST"
                httpURLConnection.doOutput = true
                httpURLConnection.doInput = true
                val outputStream = httpURLConnection.outputStream
                val bufferedWriter = BufferedWriter(OutputStreamWriter(outputStream, "UTF-8"))
                val postData = URLEncoder.encode(
                    "name",
                    "UTF-8"
                ) + "=" + URLEncoder.encode(
                    userName,
                    "UTF-8"
                ) + "&" + URLEncoder.encode(
                    "email",
                    "UTF-8"
                ) + "=" + URLEncoder.encode(
                    email,
                    "UTF-8"
                ) + "&" + URLEncoder.encode(
                    "password",
                    "UTF-8"
                ) + "=" + URLEncoder.encode(
                    password,
                    "UTF-8"
                ) + "&" + URLEncoder.encode(
                    "phone",
                    "UTF-8"
                ) + "=" + URLEncoder.encode(
                    phone,
                    "UTF-8")

                bufferedWriter.write(postData)
                bufferedWriter.flush()
                bufferedWriter.close()
                outputStream.close()
                val inputStream = httpURLConnection.inputStream
                val bufferedReader = BufferedReader(InputStreamReader(inputStream, "iso-8859-1"))
                while (bufferedReader.readLine().also { line = it } != null) {
                    result+=line
                }
                bufferedReader.close()
                inputStream.close()
                httpURLConnection.disconnect()
                //                return result;

            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        else if(type == "editData"){
            try {
                val gender = params[1]
                val mStatus = params[2]
                val height = params[3]
                val weight = params[4]
                val blood = params[5]
                val userName = params[6]
                val phone = params[7]
                val url = URL(editDataUrl)
                val httpURLConnection = url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod = "POST"
                httpURLConnection.doOutput = true
                httpURLConnection.doInput = true
                val outputStream = httpURLConnection.outputStream
                val bufferedWriter = BufferedWriter(OutputStreamWriter(outputStream, "UTF-8"))
                val postData = URLEncoder.encode(
                    "name",
                    "UTF-8"
                ) + "=" + URLEncoder.encode(
                    userName,
                    "UTF-8"
                ) + "&" + URLEncoder.encode(
                    "gender",
                    "UTF-8"
                ) + "=" + URLEncoder.encode(
                    gender,
                    "UTF-8"
                ) + "&" + URLEncoder.encode(
                    "mStatus",
                    "UTF-8"
                ) + "=" + URLEncoder.encode(
                    mStatus,
                    "UTF-8"
                ) + "&" + URLEncoder.encode(
                    "phone",
                    "UTF-8"
                ) + "=" + URLEncoder.encode(
                    phone,
                    "UTF-8"
                ) + "&" + URLEncoder.encode(
                    "height",
                    "UTF-8"
                ) + "=" + URLEncoder.encode(
                    height,
                    "UTF-8"
                ) + "&" + URLEncoder.encode(
                    "weight",
                    "UTF-8"
                ) + "=" + URLEncoder.encode(
                    weight,
                    "UTF-8"
                ) + "&" + URLEncoder.encode(
                    "blood",
                    "UTF-8"
                ) + "=" + URLEncoder.encode(
                    blood,
                    "UTF-8")

                bufferedWriter.write(postData)
                bufferedWriter.flush()
                bufferedWriter.close()
                outputStream.close()
                val inputStream = httpURLConnection.inputStream
                val bufferedReader = BufferedReader(InputStreamReader(inputStream, "iso-8859-1"))
                while (bufferedReader.readLine().also { line = it } != null) {
                    result+=line
                }
                bufferedReader.close()
                inputStream.close()
                httpURLConnection.disconnect()
                //                return result;

            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        else if(type == "view"){
            try {
                val url = URL(viewDataUrl)
                val httpURLConnection = url.openConnection() as HttpURLConnection
                httpURLConnection.requestMethod = "POST"
                httpURLConnection.doOutput = true
                httpURLConnection.doInput = true
//                val outputStream = httpURLConnection.outputStream
//                val bufferedWriter = BufferedWriter(OutputStreamWriter(outputStream, "UTF-8"))
//                val postData = URLEncoder.encode(
//                    "name",
//                    "UTF-8"
//                ) + "=" + URLEncoder.encode(
//                    userName,
//                    "UTF-8"
//                ) + "&" + URLEncoder.encode(
//                    "gender",
//                    "UTF-8"
//                ) + "=" + URLEncoder.encode(
//                    gender,
//                    "UTF-8"
//                ) + "&" + URLEncoder.encode(
//                    "mStatus",
//                    "UTF-8"
//                ) + "=" + URLEncoder.encode(
//                    mStatus,
//                    "UTF-8"
//                ) + "&" + URLEncoder.encode(
//                    "phone",
//                    "UTF-8"
//                ) + "=" + URLEncoder.encode(
//                    phone,
//                    "UTF-8"
//                ) + "&" + URLEncoder.encode(
//                    "height",
//                    "UTF-8"
//                ) + "=" + URLEncoder.encode(
//                    height,
//                    "UTF-8"
//                ) + "&" + URLEncoder.encode(
//                    "weight",
//                    "UTF-8"
//                ) + "=" + URLEncoder.encode(
//                    weight,
//                    "UTF-8"
//                ) + "&" + URLEncoder.encode(
//                    "blood",
//                    "UTF-8"
//                ) + "=" + URLEncoder.encode(
//                    blood,
//                    "UTF-8")
//
//                bufferedWriter.write(postData)
//                bufferedWriter.flush()
//                bufferedWriter.close()
//                outputStream.close()
                val inputStream = httpURLConnection.inputStream
                val bufferedReader = BufferedReader(InputStreamReader(inputStream, "iso-8859-1"))
                while (bufferedReader.readLine().also { line = it } != null) {
                    result+=line
                }
                bufferedReader.close()
                inputStream.close()
                httpURLConnection.disconnect()
                //                return result;

            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return result.toString()
    }



    override fun onPreExecute() {

        alertDialog = AlertDialog.Builder(context).create()
        alertDialog!!.setTitle("Status")

    }

    protected override fun onProgressUpdate(vararg values: Void?) {
        super.onProgressUpdate(*values)
    }

    override fun onPostExecute(result: String) {
        alertDialog!!.setMessage(result)
        alertDialog!!.show()

    }
}

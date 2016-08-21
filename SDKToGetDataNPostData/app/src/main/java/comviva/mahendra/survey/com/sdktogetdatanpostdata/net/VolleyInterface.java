package comviva.mahendra.survey.com.sdktogetdatanpostdata.net;

        import com.android.volley.VolleyError;
/* @author
	 ____                        _   _   ____  _             _
	|  _ \ _ __ __ _  __ _  __ _| |_(_) / ___|(_)_ __   __ _| |__
	| |_) | '__/ _` |/ _` |/ _` | __| | \___ \| | '_ \ / _` | '_ \
	|  __/| | | (_| | (_| | (_| | |_| |  ___) | | | | | (_| | | | |
	|_|   |_|  \__,_|\__, |\__,_|\__|_| |____/|_|_| |_|\__, |_| |_|
                     |___/                             |___/
 *
 *  Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Created by pragati on 8/18/16.
 *
 *  interface for HTTP request
 */
public interface VolleyInterface {

    public void requestStarted(int requestCode);

    public void requestCompleted(String response, int requestCode);

    public void requestEndedWithError(VolleyError error, int requestCode);
}

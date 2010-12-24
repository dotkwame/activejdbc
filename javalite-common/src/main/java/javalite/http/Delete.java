/*
Copyright 2009-2010 Igor Polevoy 

Licensed under the Apache License, Version 2.0 (the "License"); 
you may not use this file except in compliance with the License. 
You may obtain a copy of the License at 

http://www.apache.org/licenses/LICENSE-2.0 

Unless required by applicable law or agreed to in writing, software 
distributed under the License is distributed on an "AS IS" BASIS, 
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
See the License for the specific language governing permissions and 
limitations under the License. 
*/

package javalite.http;

/**
 * Executes a DELETE request.
 *
 * @author Igor Polevoy
 */
public class Delete extends Request<Delete> {

    /**
     * Constructor for making DELETE requests.
     *
     * @param uri URI of resource.
     * @param connectTimeout connection timeout.
     * @param readTimeout read timeout.
     */
    public Delete(String uri, int connectTimeout, int readTimeout) {
        super(uri, connectTimeout, readTimeout);
    }

    @Override
    public Delete doConnect() {
        try {
            connection.setDoOutput(true);
            connection.setRequestMethod("DELETE");
            connection.connect();
            return this;
        } catch (Exception e) {
            throw new HttpException(e);
        }
    }
    
    public static void main(String[] args) {
        Delete delete = Http.delete("http://localhost:8080/kitchensink/http/delete");
        System.out.println(delete.text());
        System.out.println(delete.headers());
        System.out.println(delete.responseCode());
    }
}

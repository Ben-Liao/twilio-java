/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.studio.v2;

import com.twilio.base.Updater;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.Map;

/**
 * PLEASE NOTE that this class contains beta products that are subject to
 * change. Use them with caution.
 */
public class FlowUpdater extends Updater<Flow> {
    private final String pathSid;
    private final Flow.Status status;
    private String friendlyName;
    private Map<String, Object> definition;
    private String commitMessage;

    /**
     * Construct a new FlowUpdater.
     *
     * @param pathSid The SID that identifies the resource to fetch
     * @param status The status of the Flow
     */
    public FlowUpdater(final String pathSid,
                       final Flow.Status status) {
        this.pathSid = pathSid;
        this.status = status;
    }

    /**
     * The string that you assigned to describe the Flow..
     *
     * @param friendlyName The string that you assigned to describe the Flow
     * @return this
     */
    public FlowUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * JSON representation of flow definition..
     *
     * @param definition JSON representation of flow definition
     * @return this
     */
    public FlowUpdater setDefinition(final Map<String, Object> definition) {
        this.definition = definition;
        return this;
    }

    /**
     * Description on change made in the revision..
     *
     * @param commitMessage Description on change made in the revision
     * @return this
     */
    public FlowUpdater setCommitMessage(final String commitMessage) {
        this.commitMessage = commitMessage;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Updated Flow
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Flow update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.STUDIO.toString(),
            "/v2/Flows/" + this.pathSid + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("Flow update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return Flow.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     *
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (status != null) {
            request.addPostParam("Status", status.toString());
        }

        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }

        if (definition != null) {
            request.addPostParam("Definition", Converter.mapToJson(definition));
        }

        if (commitMessage != null) {
            request.addPostParam("CommitMessage", commitMessage);
        }
    }
}
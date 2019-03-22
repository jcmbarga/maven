package org.autodatacorp.orchestration.models.miscellaneous.response;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by nurico on 2016-10-25.
 */
public class VersionList implements Serializable {
    private static final long serialVersionUID = 1429770616475816182L;
    private LinkedHashMap<String, String> versions = new LinkedHashMap();
    public void addVersion(String component, String version) {
        this.versions.put(component, version);
    }
    public Map<String, String> getVersions() {
        return this.versions;
    }
}

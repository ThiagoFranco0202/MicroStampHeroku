package Step2FormTest.domain;

import Step2FormTest.models.ConnectionType;
import Step2FormTest.models.Style;

import java.util.List;

public class ConnectionDomain {

    private Long id;
    private ConnectionType connectionType;
    private Long source_id;
    private Long target_id;
    private Style style;
    private Long control_structure_id;

    public Long getControl_structure_id() {
        return control_structure_id;
    }

    public void setControl_structure_id(Long control_structure_id) {
        this.control_structure_id = control_structure_id;
    }

    private List<String> labels_ids;

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ConnectionType getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(ConnectionType connectionType) {
        this.connectionType = connectionType;
    }

    public Long getSource_id() {
        return source_id;
    }

    public void setSource_id(Long source_id) {
        this.source_id = source_id;
    }

    public Long getTarget_id() {
        return target_id;
    }

    public void setTarget_id(Long target_id) {
        this.target_id = target_id;
    }

    public List<String> getLabels_ids() {
        return labels_ids;
    }

    public void setLabels_ids(List<String> labels_ids) {
        this.labels_ids = labels_ids;
    }
}

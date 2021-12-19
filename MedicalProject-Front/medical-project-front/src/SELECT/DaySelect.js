import React from "react";
import moment from "moment";
import { Button } from "@material-ui/core";

class DaySelect extends React.Component {

    render() {
        return(
            <div>
            <Button onClick={function() {
                var date = moment().format('YYYYMMDDhhmmss');
                this.props.onaddDate(date);
            }.bind(this)} >시작하기</Button>
            </div>
        );
    }
}

export default DaySelect;
import React from "react";
import moment from "moment";
import { Button } from "@material-ui/core";
import { WifiTetheringSharp } from "@material-ui/icons";

class DaySelect extends React.Component {

    today = moment().format('YYYYMMDDhhmmss');

    render() {
        return(
            <div>
            <Button onClick={function() {
                var date = this.today;
                this.props.onaddDate(date)
            }.bind(this)} >시작하기</Button>
            </div>
        );
    }
}

export default DaySelect;
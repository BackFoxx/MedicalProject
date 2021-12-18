import React from "react";
import { List, ListItem, ListItemButton, ListItemText, Checkbox, Grid, Slider, Button } from "@mui/material";

class SymptomAndIntensity_Select extends React.Component {
    lists = [];

    //증상별 리스트 선택
    ST_Choice = function() {
        if (this.props.part === '머리') { this.lists = ["어지러움", "두통", "방구마려움"]; return(this.ST_List()); }
        else if (this.props.part === '배') { this.lists = ["메슥거임", "소화불량", "명치아픔", "구토"]; return(this.ST_List()); }
        else if (this.props.part === '다리') { this.lists = ["시림", "불안함", "차가움"]; return(this.ST_List()); }
    }.bind(this)

    //증상 리스트
    ST_List = function() {
        var is_disabled = false;
        var sliderValue, num = 3;
        const lists = this.lists;
        var STList = [];
        var i = 0;
        while(i < lists.length) {                
            STList.push(
            <List key={i}>
                <ListItem>
                    <Checkbox />
                    <ListItemButton sx={{ width: 160 }}>
                        <ListItemText>{lists[i]}</ListItemText>
                    </ListItemButton>

                    <Slider onChange={ (e, val) => sliderValue = val } color="secondary" defaultValue={3} valueLabelDisplay="auto" step={1} marks min={1} max={10} disabled={is_disabled} />

                    <Button value={i} onClick={function(e) { this.Add(e.target.value, sliderValue) }.bind(this) }>추가</Button>
                </ListItem>
            </List>
            );
            ++i;
        }

        return( <ul>{STList}</ul> );
    }.bind(this)

    //추가 버튼
    Add = function(num, value) {
        this.props.onaddSTIN(this.lists[num], value);
    }.bind(this)

    render() {
        return(
            <Grid item xs={5}>
                {this.ST_Choice()}
            </Grid>
        );
    }
}

export default SymptomAndIntensity_Select;
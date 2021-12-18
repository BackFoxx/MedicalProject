import React from "react";
import { List, ListItem, ListItemButton, ListItemText, Checkbox, Grid, Slider, Button } from "@mui/material";

class SymptomAndIntensity_Select extends React.Component {

    //머리
    ST_Head = function() {
        const lists = ["어지러움", "두통", "발열"];
        const STList = lists.map((list, index) => 
                <List key={index}>
                    <ListItem>
                        <Checkbox />
                        <ListItemButton sx={{ width: 160 }}>
                            <ListItemText>{list}</ListItemText>
                        </ListItemButton>

                        <Slider aria-label="Temperature" defaultValue={3} valueLabelDisplay="auto" step={1} marks min={1} max={10} disabled={true} />

                        <Button disabled={true}>추가</Button>
                    </ListItem>
                </List>
        )
        return(
            
            <ul>{STList}</ul>

                
        );
    }.bind(this)

    render() {
        return(
            <Grid item xs={5}>
                {this.ST_Head()}
            </Grid>
        );
    }
}

export default SymptomAndIntensity_Select;
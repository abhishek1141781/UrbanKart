
export const SET_CURRENT_USER = 'SET_CURRENT_USER';
export const CLEAR_CURRENT_USER = 'CLEAR_CURRENT_USER';


// For Add Item to Cart


export const addCart = (product) =>{
    return {
        type:"ADDITEM",
        payload:product
    }
}

// For Delete Item to Cart
export const delCart = (product) =>{
    return {
        type:"DELITEM",
        payload:product
    }
}



export const setCurrentUser = (user) => {
    return {
        type: SET_CURRENT_USER,
        payload: user,
    };
};

export const clearCurrentUser = () => {
    console.log("in current")
    return {
        type: CLEAR_CURRENT_USER,
    };
};

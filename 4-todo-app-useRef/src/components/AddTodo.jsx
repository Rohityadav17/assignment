import { useRef } from "react";

function AddTodo({ onNewItem }) {
  const todoActionElement = useRef();
  const dueDateElement = useRef();

  const handleAddButtonClicked = (event) => {
    event.preventDefault();
    const todoAction = todoActionElement.current.value;
    const dueDate = dueDateElement.current.value;
    onNewItem(todoAction, dueDate);
  };

  return (
    <div className="container text-center">
      <form className="row kg-row" onSubmit={handleAddButtonClicked}>
        <div className="col-6">
          <input
            type="text"
            ref={todoActionElement}
            placeholder="Enter Todo Here"
          ></input>
        </div>
        <div className="col-4">
          <input type="date" ref={dueDateElement} />
        </div>
        <div className="col-2">
          <button className="btn btn-success kg-button">ADD</button>
        </div>
      </form>
    </div>
  );
}

export default AddTodo;

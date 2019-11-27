package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.esoftwarica.R;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentViewHolder> {
    Context mcontext;
    List<Students> studentsList;

    public StudentsAdapter(Context mcontext, List<Students> contactsList) {
        this.mcontext = mcontext;
        this.studentsList = contactsList;
    }
        @NonNull
        @Override
        public StudentsAdapter.StudentViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_students,parent,false);
            return new StudentViewHolder(view);
        }

        @Override
        public void onBindViewHolder (@NonNull StudentsAdapter.StudentViewHolder holder,int position)
        {
            Students students= studentsList.get(position);
            holder.imgPic.setImageResource(students.getImageId());
            holder.txtName.setText(students.getName());
            holder.txtAge.setText(students.getAge());
            holder.txtAddress.setText(students.getAddress());
            holder.txtgender.setText(students.getGender());
        }

        @Override
        public int getItemCount () {
            return studentsList.size();
        }

        public class StudentViewHolder extends RecyclerView.ViewHolder {
            ImageView imgPic, imgDelete;
            TextView txtName, txtAddress, txtAge, txtgender;

            public StudentViewHolder(@NonNull View itemView) {
                super(itemView);

                imgPic = itemView.findViewById(R.id.imgPic);
                imgDelete = itemView.findViewById(R.id.imgDelete);
                txtName = itemView.findViewById(R.id.txtName);
                txtAddress = itemView.findViewById(R.id.txtAddress);
                txtAge = itemView.findViewById(R.id.txtAge);
                txtgender = itemView.findViewById(R.id.txtgender);

                imgDelete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        removeStudent(getAdapterPosition());
                    }
                });
            }

            public void removeStudent(int position){
                studentsList.remove(position);
                notifyItemRemoved(position);
            }
        }
    }

